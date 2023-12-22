package samples.javafx.model;

import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.ListIterator;
import java.util.Random;


/**
 * Created by nuu on 12.2016.
 */
public class Wald {

    private LinkedList<Waldbestandteil> components;
    private int width;
    private int height;
    private int growth = 0;
    private int ignition = 0;

    /**
     * Constructor.
     * @param breite the width of the forest.
     * @param tiefe the depth of the forest.
     */
    public Wald(int breite, int tiefe, int probabilityOfGrowth, int probabilityOfIgnition) {
        this.width = breite;
        this.height = tiefe;
        this.growth = probabilityOfGrowth;
        this.ignition = probabilityOfIgnition;
        this.initialize();
    }

    public String toString() {
        String result = "";
        int i = 0;
        for (Waldbestandteil c : this.components) {
            if (i == this.width) {
                result += "\n";
                i = 0;
            }
            result += c.toString();
            i++;
        }

        // refresh forest for next call of toString() method
        this.refresh();

        return result;
    }

    private void initialize(){
        if (this.components != null)
            this.components.clear();
        else
            this.components = new LinkedList<Waldbestandteil>();

        for (int y = 0; y < this.height; y++) {
            for (int x = 0; x < this.width; x++) {
                Waldbestandteil c = createComponent();
                this.components.add(c);
                c.setPosX(x);
                c.setPosY(y);
            }
        }
    }

    private Waldbestandteil createComponent() {
        // generate random number between 1 and 10
        int n = new Random().nextInt(10) + 1;

        switch (n){
            // mit einer Wahrscheinlichkeit von 40% soll ein Baum entstehen
            case 1: case 2: case 3: case 4:
                return new Baum();

            // mit einer Wahrscheinlichkeit von 30% soll Humus entstehen
            case 5: case 6: case 7:
                return new Humus();

            // mit einer Wahrscheinlichkeit von 30% soll ein Stein entstehen
            default:
                return new Stein();
        }
    }

    /**
     * This method refreshes the tree, means:
     *  1. identifies all trees which are currently burning and sparks its neighbors
     *  2. finds all trees which are burnt down (means: have already sparked its neighbors) and converts them into humus
     */
    private void refresh() {
        // let's use lists to meanwhile store the components which are affected by changes within this refresh
        // we do this to avoid that changed components will be changed a 2nd time within this refresh (based on the first change)
        LinkedList<Baum> burningTrees = new LinkedList<Baum>();
        LinkedList<Baum> burntTrees = new LinkedList<Baum>();
        LinkedList<Baum> healthyTrees = new LinkedList<Baum>();
        LinkedList<Humus> humuses = new LinkedList<Humus>();

        /*
         * 1. identify status of components
         **********************************/
         for (Waldbestandteil c : this.components) {
             // trees which - during the last refresh - already have sparked their neighbors (which are burnt)
             if (c instanceof  Baum && ((Baum)c).isBurnt()) {
                 burntTrees.add((Baum)c);
             }
             // trees which currently are burning and have not yet sparked its neighbors
            else if (c instanceof  Baum && ((Baum)c).isBurning()) {
                burningTrees.add((Baum)c);
            }
                       // threes which still are healthy
            else if (c instanceof  Baum && ((Baum)c).isBurning() == false && ((Baum)c).isBurnt() == false) {
                healthyTrees.add((Baum)c);
            }
            // humuses
            else if (c instanceof  Humus) {
                humuses.add((Humus)c);
            }
        }

        /*
         * 2. let's change the status of the components
         **********************************************/
        for (Baum b : burningTrees) {
            // spark the tree's neighbors
            sparkNeighbors(b);
            // tree has sparked its neighbors and is completely burnt
            b.burnDown();
        }
        for (Baum b: burntTrees) {
            // convert burnt tree into humus
            replaceComponent(b, new Humus());
        }
        for (Baum b : healthyTrees) {
            // spark healthy trees, consider probability of ignition
            if (new Random().nextInt(100) + 1 <= this.ignition) {
                b.spark();
            }
        }
        for (Humus h : humuses) {
            // let new trees grow, consider probability of growth
            if (new Random().nextInt(100) + 1 <= this.growth) {
                replaceComponent(h, new Baum());
            }
        }
    }

    /**
     * This method is used to spark all neighbors of a specific tree.
     *
      * @param b the tree whose neighbors will be sparked.
     */
    private void sparkNeighbors(Baum b) {
        Waldbestandteil c;

        c = this.findNeighborToLeft(b);
        if (c != null && c instanceof  Baum) {
            ((Baum) c).spark();
        }

        c = this.findNeighborToRight(b);
        if (c != null && c instanceof Baum ) {
            ((Baum) c).spark();
        }

        c = this.findNeighborToTop(b);
        if (c != null && c instanceof Baum ) {
            ((Baum) c).spark();
        }

        c = this.findNeighborToBottom(b);
        if (c != null && c instanceof Baum ) {
            ((Baum) c).spark();
        }
    }

    /**
     * Finds the neighbor located to the left of a specific component.
     *
     * @param component the component of which the neighbor shall be found
     * @return the found neighbor or null if there's no neighbor
     */
    private Waldbestandteil findNeighborToLeft(Waldbestandteil component) {
        if (component.getPosX() == 0) {
            // component has no neighbor to its left because it is located leftmost
            return null;
        }

        // search for neighbor
        for (Waldbestandteil c : this.components) {
            if (c.getPosY() == component.getPosY() && c.getPosX() == component.getPosX() - 1){
                return c;
            }
        }

        return null;
    }

    /**
     * Finds the neighbor located to the right of a specific component.
     *
     * @param component the component of which the neighbor shall be found
     * @return the found neighbor or null if there's no neighbor
     */
    private  Waldbestandteil findNeighborToRight(Waldbestandteil component) {
        if (component.getPosX() == this.width - 1) {
            // component has no neighbor to its right because it is located rightmost
            return null;
        }

        // search for neighbor
        for (Waldbestandteil c : this.components) {
            if (c.getPosY() == component.getPosY() && c.getPosX() == component.getPosX() + 1){
                return c;
            }
        }

        return null;
    }

    /**
     * Finds the neighbor located to the top of a specific component.
     *
     * @param component the component of which the neighbor shall be found
     * @return the found neighbor or null if there's no neighbor
     */
    private Waldbestandteil findNeighborToTop(Waldbestandteil component) {
        if (component.getPosY() == 0) {
            // component has no neighbor to its top because it is located topmost
            return null;
        }

        // search for neighbor
        for (Waldbestandteil c : this.components) {
            if (c.getPosX() == component.getPosX() && c.getPosY() == component.getPosY() - 1){
                return c;
            }
        }

        return null;
    }

    /**
     * Finds the neighbor located to the bottom of a specific component.
     *
     * @param component the component of which the neighbor shall be found
     * @return the found neighbor or null if there's no neighbor
     */
    private Waldbestandteil findNeighborToBottom(Waldbestandteil component) {
        if (component.getPosY() == this.height - 1) {
            // component has no neighbor to its bottom because it is located bottommost
            return null;
        }

        // search for neighbor
        for (Waldbestandteil c : this.components) {
            if (c.getPosX() == component.getPosX() && c.getPosY() == component.getPosY() + 1){
                return c;
            }
        }

        return null;
    }

    private void replaceComponent(Waldbestandteil replace, Waldbestandteil replaceWith)
    {
        for (int i = 0; i < this.components.size(); i++)
        {
            if (this.components.get(i) == replace)
            {
                replaceWith.setPosX(replace.getPosX());
                replaceWith.setPosY(replace.getPosY());
                this.components.remove(i);
                this.components.add(i, replaceWith);
                break;
            }
        }
    }
}

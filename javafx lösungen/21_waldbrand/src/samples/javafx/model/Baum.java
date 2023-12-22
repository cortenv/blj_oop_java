package samples.javafx.model;

/**
 * Created by nuu on 12.2016.
 */
public class Baum extends Waldbestandteil {

    private boolean burning = false;
    private boolean burnt = false;

    /**
     * Sparks the tree.
     */
    public void spark() {
        this.burning = true;
    }

    public boolean isBurning() {
        return burning;
    }

    /**
     * Burns the tree down, completely.
     */
    public void burnDown() {
        this.burnt = true;
        this.burning = false;
    }

    public boolean isBurnt() {
        return burnt;
    }

    @Override
    public String toString() {
      if (this.isBurnt())
          return "f";
      else if (this.isBurning())
          return "F";
      else
          return "B";
    }
 }

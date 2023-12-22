package samples.javafx.model;

/**
 * Created by nuu on 12.2016.
 */
public abstract class Waldbestandteil {

    private int posX;
    private int posY;

    public int getPosY() {
        return posY;
    }

    public void setPosY(int posY) {
        this.posY = posY;
    }

    public int getPosX() {
        return posX;
    }

    public void setPosX(int posX) {
        this.posX = posX;
    }

    public abstract String toString();
}

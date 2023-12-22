package samples.javafx;

public class Rechteck {
    private double height = 0;
    private double width = 0;

    public double getWidth() {
        return width;
    }

    public void setWidth(double width) {
        this.width = width;
    }

    public double getHeight() {
        return height;
    }

    public void setHeight(double height) {
        this.height = height;
    }

    public double getArea() {
        return height * width;
    }
}

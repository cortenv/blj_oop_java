package com.example.t02_rechteckberechnen;

public class Rechteck {

    private double height;
    private double width;

    public double getHeight() { return height; }
    public double getWidth() { return width; }

    public void setHeight(double height) {
        this.height = height;
    }
    public void setWidth(double width) { this.width = width; }

    public double getArea() {
        return height * width;
    }

}
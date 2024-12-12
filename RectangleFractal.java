package com.example.finalproject;

public class RectangleFractal implements Fractal {
    Rectangle rectangle;
    int numLevels;
    Point center;

    public RectangleFractal(Rectangle rectangle, int numLevels, Point center) {
        this.rectangle = rectangle;
        this.numLevels = numLevels;
        this.center = center;
    }



    public Point[] getPoints() {
        return null;
    }


    public Line[] getLines() {

        return null;
    }


}

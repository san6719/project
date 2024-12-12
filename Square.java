package com.example.finalproject;

public class Square extends Rectangle implements RegularPolygonFractal,Fractal{

    /**
     * constructor for square class
     * @param center
     * @param length
     */
    public Square(Point center, double length) {
        super(center,length,length);
    }
}

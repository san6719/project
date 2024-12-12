package com.example.finalproject;

public class EquilateralTriangle extends Triangle implements RegularPolygonFractal,Fractal{

    Point p3;
    Point p1;
    Point p2;
    double length;
    /**
     * constructor for equilateral triangle
     * @param p1
     * @param length
     */
    public EquilateralTriangle(Point p1, double length) {

        super(new Point[] {p1,new Point(p1.getX()-(length/2),p1.getY()-(Math.sqrt(3)/2)*length), new Point(p1.getX()+(length/2),p1.getY()-(Math.sqrt(3)/2)*length)});
        this.p1 = p1;
        this.length = length;

        double height = (Math.sqrt(3)/2)*length;
        p2 = new Point(p1.getX()-(length/2),p1.getY()-height);
        p3 = new Point(p1.getX()+(length/2),p1.getY()-height);


    }

}

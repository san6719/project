package com.example.finalproject;


public class Rectangle extends Polygon {
    Point center;
    double height;
    double width;
    Point[] points;

    /**
     * constructor for rectangle class
     * @param center
     * @param height
     * @param width
     */
    public Rectangle(Point center, double height, double width) {
        super(new Point[]{new Point(center.getX()-(height/2),center.getY()+(width/2)),
                new Point(center.getX()+(height/2),center.getY()+(width/2)),
                new Point(center.getX()+(height/2),center.getY()-(width/2)),
                new Point(center.getX()-(height/2),center.getY()-(width/2))});

        points = new Point[] {new Point(center.getX()-(height/2),center.getY()+(width/2)),
                new Point(center.getX()+(height/2),center.getY()+(width/2)),
                new Point(center.getX()+(height/2),center.getY()-(width/2)),
                new Point(center.getX()-(height/2),center.getY()-(width/2))};
        setCenter(center);
        this.height = height;
        this.width = width;
    }



    /**
     * sets the 4 lines that make up a square
     * @return array of lines
     */
    @Override
    public Line[] getLines() {
        Line top = new Line(getPoints()[0],getPoints()[1]);
        Line right = new Line(getPoints()[1],getPoints()[2]);
        Line bottom = new Line(getPoints()[2],getPoints()[3]);
        Line left = new Line(getPoints()[3],getPoints()[0]);

        Line[] lineArray = {top,right,bottom,left};
        return lineArray;
    }
    /**
     * returns an array of points
     * @return points
     */

    public Point[] getPoints() {
        return this.points;
    }

    /**
     * returns the width
     * @return width
     */
    public double getWidth() {
        return this.width;
    }

    /**
     * sets the width
     * @param width
     */
    public void setWidth(double width) {
        this.width = width;

    }

    /**
     * sets the height
     * @param height
     */
    public void setHeight(double height) {
        this.height = height;
    }

    /**
     * gets height
     * @return height
     */
    public double getHeight() {
        return this.height;

    }

}

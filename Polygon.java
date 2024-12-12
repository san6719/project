package com.example.finalproject;


public abstract class Polygon {

    Point p;
    Point points[];
    /**
     * constructor for polygon
     * @param points
     */
    public Polygon(Point points[]) {
        if(points.length < 3) {
            throw new IllegalArgumentException("Polygon must have 3 points");
        }

        this.points=points;

    }

    /**
     * gets the center point
     * @return center point
     */
    public Point getCenter() {

        return p;
    }
    /**
     * sets the center point
     * @param p
     */
    public void setCenter(Point p) {
        this.p = p;
    }
    /*
     * returns a point array
     * @return Point[]
     */
    public abstract Point[] getPoints();

    /*
     * rotates the points in the array by given degree
     * @param double angle
     */
    public void rotate(double angle) {

        Point[] pointArray = getPoints();

        for(int i = 0; i<pointArray.length;i++) {
            pointArray[i].rotateAbout(p,angle);
        }
    }
    /*
     * returns a line array
     * @return line[]
     */

    public abstract Line[] getLines();


}

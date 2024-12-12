package com.example.finalproject;

public class Triangle extends Polygon implements Fractal{

    Point[] points;
    /**
     * Constructor for triangle class
     * @param points
     */
    public Triangle(Point[] points) {
        super(points);
        this.points = points;
    }
    /**
     * calculates and returns the center of a triangle
     * @return center of the triangle
     */

    public Point getCenter() {
        double x = (points[0].getX()+points[1].getX()+points[2].getX())/3;
        double y = (points[0].getY()+points[1].getY()+points[2].getY())/3;
        Point center = new Point(x,y);
        return center;
    }
    /**
     * sets the center of the triangle
     * @param p
     */
    public void setCenter(Point p) {
        double changeX = getCenter().getX() -p.getX();
        double changeY = getCenter().getY() - p.getY();
        points[0].setX(points[0].getX()+changeX);
        points[0].setY(points[0].getY()+changeY);

        points[1].setX(points[1].getX()+changeX);
        points[1].setY(points[1].getY()+changeY);

        points[2].setX(points[2].getX()+changeX);
        points[2].setY(points[2].getY()+changeY);

    }
    /**
     * returns the array of the points of the triangle
     * @return array of points
     */
    public Point[] getPoints() {

        return points;

    }

    /**
     * gets the array of lines
     * @return returns the array of lines
     */

    @Override
    public Line[] getLines() {

        Line[] lineArray = {
                new	Line(getPoints()[0],getPoints()[1]),
                new Line(getPoints()[1],getPoints()[2]),
                new Line(getPoints()[2],getPoints()[0])

        };
        return lineArray;


    }


}
package com.example.finalproject;

public class Line {
    private Point firstPoint;
    private Point secondPoint;
    /**
     * constructor for line
     * @param firstPoint
     * @param secondPoint
     */
    public Line(Point firstPoint, Point secondPoint) {
        this.firstPoint = firstPoint;
        this.secondPoint = secondPoint;

    }
    /**
     * constructor for Line
     * @param x1
     * @param y1
     * @param x2
     * @param y2
     */
    public Line(double x1, double y1, double x2, double y2) {
        this.firstPoint = new Point(x1, y1);
        this.secondPoint = new Point(x2, y2);

    }
    /**
     * returns the first point in a line
     * @return Point
     */
    public Point getFirstPoint() {

        return firstPoint;
    }
    /**
     * returns second point in line
     * @return Point
     */
    public Point getSecondPoint() {
        return secondPoint;
    }
    /**
     * sets the first point
     * @param p
     */
    public void setFirstPoint(Point p) {
        this.firstPoint = p;
    }
    /**
     * sets the second point
     * @param p
     */
    public void setSecondPoint(Point p) {
        this.secondPoint = p;
    }
    /**
     * returns the line array
     * @return Line[]
     */
    public Line[] getLines() {

        Line[] lineArray = {this};

        return lineArray;

    }
}

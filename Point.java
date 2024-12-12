package com.example.finalproject;

public class Point {

    private double x;
    private double y;
    /**
     * constructor for point, takes an x and y coordinate
     * @param x
     * @param y
     */
    public Point(double x, double y) {
        this.x = x;
        this.y = y;
    }
    /**
     * sets x coordinate
     * @param x
     */
    public void setX(double x) {
        this.x = x;
    }
    /**
     * sets y coordinate
     * @param y
     */
    public void setY(double y) {
        this.y = y;
    }
    /**
     * returns the x coordinate
     * @return x
     */
    public double getX() {
        return this.x;
    }
    /**
     * returns the y coordinate
     * @return y
     */
    public double getY() {
        return this.y;
    }
    /**
     * rotates points around a point for a given angle
     * @param p
     * @param angle
     */
    public void rotateAbout(Point p, double angle) {
        angle = Math.toRadians(angle);
        double originX = x - p.getX();
        double originY = y - p.getY();

        double rotatedX = (originX * Math.cos(angle)) - (originY *Math.sin(angle));
        double rotatedY =  (originX * Math.sin(angle)) + (originY *Math.cos(angle));

        setX(rotatedX + p.getX());
        setY(rotatedY + p.getY());
    }
}

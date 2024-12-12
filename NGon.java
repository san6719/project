package com.example.finalproject;


public class NGon extends Polygon implements RegularPolygonFractal,Fractal{

    double length;
    int numSides;
    Point[] points;

    /**
     * Constructor for NGon
     * @param center
     * @param length
     * @param numSides
     */
    public NGon(Point center, double length,int numSides) {
        super(new Point[numSides]);
        this.p = center;
        this.numSides = numSides;
        this.length = length;
        this.points = new Point[numSides];
        setPoints();
    }
    /**
     * returns the length
     * @return length
     */
    public double getLength()
    {
        return this.length;
    }
    /**
     * returns the number of sides
     * @return numSides
     */
    public int getNumSides() {
        return this.numSides;
    }
    /**
     * sets the coordinates of all the points
     */
    public void setPoints(){
        double increment = 2 * Math.PI /getNumSides();
        for(int i = 0; i < numSides;i++) {
            double angle = i * increment;
            double x = p.getX() + getLength() * Math.cos(angle);
            double y = p.getY() +getLength() * Math.sin(angle);
            points[i] = new Point(x,y);
        }
    }
    /**
     * returns points
     * @return Point[]
     */
    @Override
    public Point[] getPoints() {
        return points;
    }
    /**
     * returns an array of lines
     * @return Line[]
     */

    @Override
    public Line[] getLines() {
        Line[] lineArray = new Line[getNumSides()];

        for(int i = 0; i < getNumSides(); i++) {
            Point startPoint = points[i];
            Point endPoint = points[(i+1)%getNumSides()];
            lineArray[i] = new Line(startPoint, endPoint);
        }

        return lineArray;
    }



}

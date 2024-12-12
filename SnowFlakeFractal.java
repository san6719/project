package com.example.finalproject;
import java.util.ArrayList;
import java.util.LinkedList;
public class SnowFlakeFractal implements Fractal {
    RegularPolygonFractal shape;
    int numLevels;
    Point center;

    public SnowFlakeFractal(RegularPolygonFractal shape, int numLevels) {
        this.shape = shape;
        this.numLevels = numLevels;
    }
    public RegularPolygonFractal getBaseShape() {
        return this.shape;
    }
    public int getNumLevels() {

        return this.numLevels;
    }
    public void setNumLevels(int numLevels) {

        this.numLevels = numLevels;
    }
    public void setCenter(Point center) {

        this.center = center;
    }


    public Point[] getPoints() {
        if(numLevels == 0) {
            return getBaseShape().getPoints();
        }
        ArrayList<Point> points = new ArrayList<>();

        for(Point p: getBaseShape().getPoints()) {
            points.add(p);
        }

        for(int i = 1; i <=getNumLevels(); i++) {
            ArrayList<Point> newPoints = new ArrayList<>();

            for (int j = 0; j < points.size(); j++) {
                Point p1 = points.get(j);
                Point p2 = points.get((j + 1) % points.size());

                Point oneThird =  new Point((2.0 / 3.0) * p1.getX() + (1.0 / 3.0) * p2.getX(), (2.0 / 3.0) * p1.getY() + (1.0 / 3.0) * p2.getY());
                Point twoThird = new Point((1.0 / 3.0) * p1.getX() + (2.0 / 3.0) * p2.getX(), (1.0 / 3.0) * p1.getY() + (2.0 / 3.0) * p2.getY());
                Point top = new Point(oneThird.getX(), oneThird.getY());

                if(shape.getClass() != Square.class) {
                    top.rotateAbout(twoThird, 60);
                } else {
                    top.rotateAbout(twoThird, -60);
                }

                newPoints.add(p1);
                newPoints.add(oneThird);
                newPoints.add(top);
                newPoints.add(twoThird);

            }

            points = newPoints;
        }
        Point[] pointArray = new Point[points.size()];
        for(int i = 0; i < points.size(); i++) {
            pointArray[i] = points.get(i);
        }

        return pointArray;

    }

    public Line[] getLines() {

        if(numLevels == 0) {
            return getBaseShape().getLines();
        }

        ArrayList<Line> lines = new ArrayList<>();
        Point[] points = getPoints();
        for(int i = 0; i < points.length; i++) {
            Point p1 = points[i];
            Point p2 = points[(i+1)%points.length];
            lines.add(new Line(p1,p2));
        }


        Line[] linesArray = new Line[lines.size()];

        for(int i=0; i<lines.size();i++) {
            linesArray[i] = lines.get(i);
        }


        return linesArray;
    }

}

package com.example.finalproject;

import java.util.ArrayList;

public class TriangleFractal implements Fractal {
    Triangle triangle;
    int numLevels;
    Point center;

    public TriangleFractal(Triangle triangle, int numLevels) {
        this.triangle = triangle;
        this.numLevels = numLevels;
    }

    public Triangle getBaseShape() {
        return this.triangle;
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
    public Point getCenter() {
        return this.center;
    }

    public Point[] getPoints() {

        if (this.numLevels == 0) {
            return getBaseShape().getPoints();
        }

        ArrayList<Point> points = new ArrayList<>();
        ArrayList<Triangle> triangles = new ArrayList<>();

        triangles.add(getBaseShape());

        for(Point p: getBaseShape().getPoints()) {
            points.add(p);
        }
        for(int i=0; i<getNumLevels(); i++) {
            ArrayList<Triangle> newTriangles = new ArrayList<>();

            for(Triangle t: triangles) {

                Point p1 = t.getPoints()[0];
                Point p2 = t.getPoints()[1];
                Point p3 = t.getPoints()[2];

                Point midPoint1 = new Point((p1.getX()+p2.getX())/2.0, (p1.getY()+p2.getY())/2.0);
                Point midPoint2 = new Point((p2.getX()+p3.getX())/2.0, (p2.getY()+p3.getY())/2.0);
                Point midPoint3 = new Point((p3.getX()+p1.getX())/2.0, (p3.getY()+p1.getY())/2.0);

                Point[] points1 = {p1,midPoint1,midPoint3};
                Triangle t1 = new Triangle(points1);

                Point[] points2 = {midPoint1,p2,midPoint2};
                Triangle t2 = new Triangle(points2);

                Point[] points3 = {midPoint3,midPoint2,p3};
                Triangle t3 = new Triangle(points3);

                newTriangles.add(t1);
                newTriangles.add(t2);
                newTriangles.add(t3);

            }

            triangles = newTriangles;


        }

        for(Triangle t: triangles) {
            points.add(t.getPoints()[0]);
            points.add(t.getPoints()[1]);
            points.add(t.getPoints()[2]);
        }

        Point[] fractalPoints = new Point[points.size()];

        for(int i=0; i<points.size(); i++) {
            fractalPoints[i] = points.get(i);
        }



        return fractalPoints;

    }

    public Line[] getLines() {

        if(getNumLevels() == 0) {
            return getBaseShape().getLines();
        }

        ArrayList<Line> lines = new ArrayList<>();
        Point[] points = getPoints();

        for(int i=0; i<points.length; i+=3) {
            Point p1 = points[i];
            Point p2 = points[(i+1)];
            Point p3 = points[(i+2)];
            lines.add(new Line(p1,p2));
            lines.add(new Line(p2,p3));
            lines.add(new Line(p3,p1));

        }

        Line[] linesArray = new Line[lines.size()];

        for(int i=0; i<lines.size();i++) {
            linesArray[i] = lines.get(i);
        }


        return linesArray;
    }

}

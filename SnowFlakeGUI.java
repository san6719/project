package com.example.finalproject;
import javafx.application.Application;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.scene.control.*;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import javafx.scene.control.Slider;
//import java.awt.event.MouseEvent;
import javafx.scene.Scene;
import javafx.event.EventHandler;
import javafx.scene.layout.BorderPane;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;
import javafx.event.ActionEvent;
import javafx.geometry.Orientation;
import javafx.scene.layout.HBox;
import javafx.geometry.Pos;
import javafx.scene.layout.VBox;
import javafx.scene.control.Spinner;
import javafx.beans.property.StringProperty;

import java.util.ArrayList;

public class SnowFlakeGUI extends Application {

    Polygon shape;
    int levels;
    int fractalType;
    Fractal fractal;

    public void setFractal(Fractal fractal) {
        this.fractal = fractal;
    }
    public Fractal getFractal(){
        return this.fractal;
    }

    public Polygon getShape() {
        return this.shape;
    }
    public void setShape(Polygon shape) {
        this.shape = shape;
    }

    public int getLevels(){
        return this.levels;
    }
    public void setLevels(int levels) {
        this.levels= levels;
    }



    public void setFractalType(int fractalType) {
        this.fractalType = fractalType;
    }
    public int getFractalType() {
        return this.fractalType;
    }

    ArrayList<Line[]> list = new ArrayList<>();

    public void start(Stage primaryStage) {
        BorderPane borderPane = new BorderPane();

        ToggleGroup toggleGroup = new ToggleGroup();
        RadioButton button1 = new RadioButton("Snowflake Fractal");
        RadioButton button2 = new RadioButton("Triangle Fractal");
        RadioButton button3 = new RadioButton("Rectangle Fractal");

        button1.setToggleGroup(toggleGroup);
        button2.setToggleGroup(toggleGroup);
        button3.setToggleGroup(toggleGroup);

        Button drawButton = new Button("Draw");
        drawButton.setVisible(false);
        Button resetButton = new Button("Reset");
        resetButton.setVisible(false);



        Slider slider = new Slider(0,10,0);
        slider.setShowTickLabels(true);
        slider.setShowTickMarks(true);
        slider.setMajorTickUnit(1);
        slider.setMinorTickCount(0);
        slider.setBlockIncrement(1);
        slider.setSnapToTicks(true);
        slider.setPrefWidth(100);
        slider.setVisible(false);

        Spinner<Integer> numSides = new Spinner<>(3,10,3);
        Spinner<Integer> sideLength = new Spinner<>(1,500,100);
        Spinner<Integer> rotation = new Spinner<>(0,360,0);

        Spinner<Integer> x1 = new Spinner<>(0,500,200);
        x1.setEditable(true);

        Spinner<Integer> y1 = new Spinner<>(0,600,200);
        y1.setEditable(true);

        Spinner<Integer> x2 = new Spinner<>(0,500,300);
        x2.setEditable(true);
        Spinner<Integer> y2 = new Spinner<>(0,600,200);
        y2.setEditable(true);

        Spinner<Integer> x3 = new Spinner<>(0,500,400);
        x3.setEditable(true);
        Spinner<Integer> y3 = new Spinner<>(0,600,300);
        y3.setEditable(true);

        rotation.setEditable(true);
        rotation.setVisible(true);
        rotation.setPromptText("Set Rotation");

        sideLength.setEditable(true);
        sideLength.setVisible(true);

        numSides.setEditable(true);
        numSides.setVisible(true);

        Text rotationText = new Text("Rotation");
        Text sideLengthText = new Text("Length");
        Text numSidesText = new Text("Num Sides");

        Text x1Text = new Text("x1");
        Text y1Text = new Text("y1");
        Text x2Text = new Text("x2");
        Text y2Text = new Text("y2");
        Text x3Text = new Text("x3");
        Text y3Text = new Text("y3");

        Canvas canvas = new Canvas();
        GraphicsContext graphicsContext = canvas.getGraphicsContext2D();






        toggleGroup.selectedToggleProperty().addListener(new ChangeListener<Toggle>() {
            public void changed(ObservableValue<? extends Toggle> observable, Toggle oldValue, Toggle newValue) {

                RadioButton rb = (RadioButton)toggleGroup.getSelectedToggle();

                if(rb == button1) {
                    System.out.println("Button1 pressed");
                    setFractalType(0);
                    slider.setVisible(true);
                    numSides.setVisible(true);
                    drawButton.setVisible(true);
                    resetButton.setVisible(true);
                } else if(rb == button2) {
                    System.out.println("Button2 pressed");
                    setFractalType(1);
                    slider.setVisible(true);
                    numSides.setVisible(false);
                    drawButton.setVisible(true);
                    resetButton.setVisible(true);
                } else if(rb == button3) {
                    System.out.println("Button3 pressed");
                    setFractalType(2);
                    slider.setVisible(true);
                    numSides.setVisible(false);
                    drawButton.setVisible(true);
                    resetButton.setVisible(true);
                }
            }
        });

        drawButton.setOnAction(event -> {
            Point point = new Point(250, 300);
            setLevels((int)slider.getValue());
            if(fractalType == 0) {
                if (numSides.getValue() == 3) {
                    point = new Point(250, 400);
                    setShape(new EquilateralTriangle(point, sideLength.getValue()));

                } else if (numSides.getValue() == 4) {
                    point = new Point(250, 300);
                    setShape(new Square(point, sideLength.getValue()));
                } else {
                    point = new Point(250, 300);
                    setShape(new NGon(point, sideLength.getValue(), numSides.getValue()));

                }
                setFractal(new SnowFlakeFractal((RegularPolygonFractal)getShape(),getLevels()));

            } else if(fractalType==1) {
                Point p1 = new Point(x1.getValue(), x2.getValue());
                Point p2 = new Point(x2.getValue(), y2.getValue());
                Point p3 = new Point(x3.getValue(), y3.getValue());
                Point[] points = {p1,p2,p3};
                setShape(new Triangle(points));
                setFractal(new TriangleFractal((Triangle)getShape(),getLevels()));

            }

            for(Point p : getShape().getPoints()){
                p.rotateAbout(getShape().getCenter(),rotation.getValue());
            }



            setLevels((int)slider.getValue());



            list.add(fractal.getLines());

            graphicsContext.setStroke(Color.BLACK);
            graphicsContext.setLineWidth(1);
            System.out.println(list.get(0).length);
            for(Line l : fractal.getLines()) {
                graphicsContext.strokeLine(l.getFirstPoint().getX(),l.getFirstPoint().getY(),l.getSecondPoint().getX(),l.getSecondPoint().getY());
            }


        });

        resetButton.setOnAction(event -> {
            graphicsContext.clearRect(0,0,canvas.getWidth(),canvas.getHeight());

        });




        //Canvas canvas = new Canvas();
        canvas.setHeight(600);
        canvas.setWidth(500);

        borderPane.setCenter(canvas);
        HBox hBox = new HBox();


        VBox vBox = new VBox(button1, button2, button3);
        VBox vBox2 = new VBox(numSidesText,numSides,rotationText,rotation,sideLengthText,sideLength,slider);


        VBox vBox3 = new VBox(drawButton, resetButton);
        VBox vBox4 = new VBox(x1Text,x1,x2Text,x2,x3Text,x3);
        VBox vBox5 = new VBox(y1Text,y1,y2Text,y2,y3Text,y3);




        hBox.getChildren().addAll(vBox,vBox2,vBox3,vBox4,vBox5);

        borderPane.setTop(hBox);


        Scene scene = new Scene(borderPane);
        primaryStage.setScene(scene);

        primaryStage.show();
    }

    public static void main(String[] args) {
        Application.launch(args);
        Point p1 = new Point(250, 300);
        Point p2 = new Point(300, 400);
        Point p3 = new Point(100, 300);
        Triangle triangle = new Triangle(new Point[]{p1,p2,p3});
        Fractal t1 = new TriangleFractal(triangle,3);
        System.out.println(t1.getClass());
        for(Point p : t1.getPoints()){
            System.out.println(p.getX()+" "+p.getY());
        }


    }
}

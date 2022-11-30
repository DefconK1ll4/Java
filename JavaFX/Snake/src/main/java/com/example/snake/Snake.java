package com.example.snake;

import javafx.animation.AnimationTimer;
import javafx.animation.FadeTransition;
import javafx.animation.PathTransition;
import javafx.animation.Timeline;
import javafx.application.Application;
import javafx.event.EventHandler;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.control.skin.TextInputControlSkin;
import javafx.scene.image.Image;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseButton;
import javafx.scene.input.MouseEvent;
import javafx.scene.input.PickResult;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.BackgroundImage;
import javafx.scene.layout.GridPane;
import javafx.scene.paint.Color;
import javafx.scene.paint.Paint;
import javafx.scene.shape.CubicCurveTo;
import javafx.scene.shape.MoveTo;
import javafx.scene.shape.Path;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;
import javafx.util.Duration;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Snake extends Application {
    @Override
    public void start(Stage stage) throws IOException {
        int snakePosX = 0;
        int snakePosY = 0;
        int speed = 0;
        int foodPosX = 0;
        int foodPosY = 0;
        int ww = 0;
        int wh = 0;

        stage.setTitle("Snake Classic");


        Group root = new Group();
        Scene scene = new Scene(new Group(), 500,500);
        scene.setFill(Color.WHITE);
        final Rectangle rectPath = new Rectangle (0, 0, 40, 40);
        rectPath.setArcHeight(10);
        rectPath.setArcWidth(10);
        rectPath.setFill(Color.ORANGE);
        ((Group)scene.getRoot()).getChildren().addAll(rectPath);
        stage.setScene(scene);

        //Canvas canvas = new Canvas(500, 500);
        //root.getChildren().add(canvas);




        List<String> keys = new ArrayList<>();

        scene.setOnKeyPressed(
                e -> {
                    String key = e.getCode().toString();
                    if (!keys.contains(key)) {
                        keys.add(key);
                    }
                });
        scene.setOnKeyReleased(
                e -> {
                    String key = e.getCode().toString();
                    keys.remove(key);
                });

        //GraphicsContext gc = canvas.getGraphicsContext2D();

        if(keys.)) {
            new MoveTo(Direction.RIGHT);
        }
        stage.show();
    }
    public static void main(String[] args) {
        launch();
    }
}
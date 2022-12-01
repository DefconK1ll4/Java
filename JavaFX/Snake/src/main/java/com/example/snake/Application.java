package com.example.snake;

import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.input.KeyEvent;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Application extends javafx.application.Application {
    @Override
    public void start(Stage stage) throws IOException, InterruptedException {
        Snake snake = new Snake();
        double newSnakePosX = 0;
        double newSnakePosY = 0;
        int canvasW = 500;
        int canvasH = 500;
        double currentPosX = canvasW / 2;
        double currentPosY = canvasH / 2;
        int speed = 0;
        double foodSizeW;
        double foodSizeH;
        double maxFoodPosX = 500;
        double maxFoodPosY = 500;
        int ww = 0;
        int wh = 0;

        stage.setTitle("Snake Classic");

        Rectangle snakeBox = snake.createSnake();

        snakeBox.setX(currentPosX); // Width
        snakeBox.setY(currentPosY); // Height

        // Canvas canvas = new Canvas(500, 500);
        // root.getChildren().add(canvas);

        List<String> keys = new ArrayList<>();

        EventHandler<KeyEvent> keyP = new EventHandler<KeyEvent>() {
            @Override
            public void handle(KeyEvent e) {
                String key = e.getCode().toString();
                if (!keys.contains(key)) {
                    keys.add(key);
                }
            }
        };
        EventHandler<KeyEvent> keyR = new EventHandler<KeyEvent>() {
            @Override
            public void handle(KeyEvent e) {
                String key = e.getCode().toString();
                keys.remove(key);
            }
        };

        snakeBox.addEventFilter(KeyEvent.KEY_PRESSED, keyP);

        //Group root = new Group(snakeBox);
        Scene scene = new Scene(new Group(snakeBox), 500, 500);
        scene.setFill(Color.WHITE);

        ((Group) scene.getRoot()).getChildren().addAll(snakeBox);
        stage.setScene(scene);


        //GraphicsContext gc = canvas.getGraphicsContext2D();

        if (keys.contains("LEFT")) {
            if(!(snakeBox.getX()-100 < canvasW-snake.getWidth())) {
                snakeBox.setX(currentPosX - 100);
            }
        } else if(keys.contains("RIGHT")) {
            if(!(snakeBox.getX()+100 > canvasW-snake.getWidth())) {
                snakeBox.setX(currentPosX + 100);
            }
        }
        stage.show();
    }
    public static void main(String[] args) {
        launch();
    }
}
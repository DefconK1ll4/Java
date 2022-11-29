package com.example.snake;

import javafx.animation.AnimationTimer;
import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.BackgroundImage;
import javafx.scene.layout.GridPane;
import javafx.scene.paint.Paint;
import javafx.stage.Stage;

import java.io.IOException;

public class Snake extends Application {
    @Override
    public void start(Stage stage) throws IOException {
        stage.setTitle("Snake Classic");


        Group root = new Group();
        Scene scene = new Scene(root);
        stage.setScene(scene);

        Canvas canvas = new Canvas(512, 512);
        root.getChildren().add(canvas);

        GraphicsContext gc = canvas.getGraphicsContext2D();

        AnimatedImage snake = new AnimatedImage();
        Image[] imgArr = new Image[100];
        for (int i = 0; i < 100; i++) {
            imgArr[i] = new Image("C:\\Users\\DefconK1ll4\\Desktop\\GithubJava\\JavaFX\\Snake\\src\\main\\java\\com\\example\\snake\\snakeBox.png");
        }
        snake.frames = imgArr;
        snake.duration = 0.100;

        final long startNanoTime = System.nanoTime();
        new AnimationTimer() {
            public void handle(long currentNanoTime) {
                double t = (currentNanoTime - startNanoTime) / 1000000000.0;
                double x = 232 + 128 * Math.cos(t);
                double y = 232 + 128 * Math.sin(t);

                gc.drawImage(snake.getFrame(t), 450, 25);
            }
        }.start();

        stage.show();
        }

    public static void main(String[] args) {
        launch();
    }
}
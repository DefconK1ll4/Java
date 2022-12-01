package com.example.snake;

import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;

import java.util.ArrayList;
import java.util.List;

public class Snake {
    private int height;
    private int width;
    private Color color;
    List<Rectangle> snakeBody = new ArrayList<>();

        public Rectangle createSnake() {
            this.height = 15;
            this.width = 15;
            this.color = Color.ORANGE;
            return new Rectangle(height,width,color);
        }

    public int getHeight() {
        return height;
    }

    public int getWidth() {
        return width;
    }

    public void setColor(Color color) {
        this.color = color;
    }
}

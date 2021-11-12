package com.example.demo;

import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

public class staticThing {
    private double x,y;
    private ImageView imageView;


    public staticThing(double x, double y, String bg) {
        this.x = x;
        this.y = y;


        Image image = new Image(ClassLoader.getSystemResourceAsStream( bg ));
        this.imageView=new ImageView(image);
        this.imageView.setY(this.y);
        this.imageView.setX(this.x);
    }

    public ImageView getImageView() {
        return imageView;
    }

    public double getX() {
        return x;
    }

    public double getY() {
        return y;
    }

    public void setX(double x) {this.x = x;}

    public void setY(double y) {this.y = y;}

}

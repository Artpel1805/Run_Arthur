package com.example.demo;

import javafx.geometry.Rectangle2D;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

public class Pig extends AnimatedThing {
    private int[] wArray = {120,123,120,119};
    private int[] hArray = {111,99,111,111};
    private int[] vpXArray = {0,120,0,243};
    private int[] vpYArray = {0,0,0,0};
    private double x;
    private double y;
    private ImageView imageView;
    private int index=0;
    private int state=0;
    private boolean newPig = false;

    public Pig(String path, double x, double y) {
        super(path, x, y);
        this.x=x;
        this.y=y;
        Image image = new Image(ClassLoader.getSystemResourceAsStream( path ));
        this.imageView = new ImageView(image);
        this.imageView.setViewport(new Rectangle2D(this.vpXArray[0],this.vpYArray[0],this.wArray[0],this.hArray[0]));
        this.imageView.setY(this.y);
        this.imageView.setX(this.x);
    }

    @Override
    public double getX() {
        return x;
    }
    @Override
    public double getY() {
        return y;
    }
    public ImageView getImageView() {
        return imageView;
    }
    @Override
    public void setX(double x) {
        this.x = x;
    }
    @Override
    public void setY(double y) {
        this.y = y;
    }
    public void setImageView(ImageView imageView) {
        this.imageView = imageView;
    }

    public boolean getNewPig() {return newPig;}

    @Override
    void update(double time) {
        if ((Math.random() < 0.1) && (state == 1)) {
            newPig = false;
            this.getImageView().setX(800);
            this.setX(800);
            state=0;
        }

        if(this.x<-123){
            state=1;
            newPig = true;
        }

        this.index = (index + 1) % 4;
        this.imageView.setViewport(new Rectangle2D(this.vpXArray[this.index], this.vpYArray[this.index], this.wArray[this.index], this.hArray[this.index]));
        setX(this.x-10);
        this.getImageView().setX(this.x);
    }
}

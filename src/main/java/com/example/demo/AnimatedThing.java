package com.example.demo;


import javafx.scene.Group;

public abstract class AnimatedThing {
    private double x,y;


    public AnimatedThing(String path, double x, double y){

        this.x=x;
        this.y=y;
    }



    public double getY() {
        return y;
    }

    public double getX() {
        return x;
    }

    public void setX(double x) {this.x = x;}

    public void setY(double y) {this.y = y;}

    abstract void update(double time);
}

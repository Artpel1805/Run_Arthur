package com.example.demo;

import com.example.demo.Hero;
public class Camera {
    private double x;
    private double y;
    private Hero hero;
    private double ax=0;
    private double vx;

    public Camera(double x, double y, Hero hero){
        this.x=x;
        this.y=y;
       this.hero=hero;
    }

    public double getX() {
        return x;
    }

    public void setX(double x) {
        this.x = x;
    }

    public void setY(double y) {
        this.y = y;
    }

    public double getY() {
        return y;
    }

    public void update(double time){
        this.ax=7*(hero.getX()-this.x)-1.1*vx;
        this.vx+=this.ax*time;
        this.x+=this.vx*time ;
        hero.getImageView().setX(hero.getX()-this.x);
    }

    @Override
    public String toString(){
        return (x + ", "+ y);
    }


}

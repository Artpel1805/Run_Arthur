package com.example.demo;



import javafx.geometry.Rectangle2D;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;



public class Hero extends AnimatedThing{
    private ImageView imageView;
    private int[] wArray = {54,70,77,60,60,73};
    private int[] hArray = {85,94,85,89,94,81};
    private int[] vpXArray = {21,93,174,271,351,428};
    private int[] vpYArray = {13,4,13,9,4,17};
    private int index=0;
    private long deltaT=16;
    private double x;
    private double y;
    private int state =0;
    private double vx=0;
    private double vsaut=7*85/1.7;
    private double vy=0;
    final double ay=-9.81*85/1.3;
    private double deltay=200;


    public Hero(String path, double x, double y) {

        super(path, x, y);
        this.x=x;
        this.y=y;
        Image image = new Image(ClassLoader.getSystemResourceAsStream( path ));
        this.imageView = new ImageView(image);
        this.imageView.setViewport(new Rectangle2D(this.vpXArray[0],this.vpYArray[0],this.wArray[0],this.hArray[0]));
        this.imageView.setY(this.y);
        this.imageView.setX(this.x);

    }

    public ImageView getImageView() {
        return imageView;
    }

    @Override
    public double getX() {
        return x;
    }

    @Override
    public void setX(double x) {
        this.x = x;
    }

    @Override
    void update(double time) {
        final double a = 60 * 9.81 - 0.8 * vx;
        vx += a * time / 1000;
        this.x += vx * time / 1000;

        if (state == 0) {
            this.setY(200);
            this.getImageView().setY(this.getY());
            this.index = (index + 1) % 6;
            this.imageView.setViewport(new Rectangle2D(this.vpXArray[this.index], this.vpYArray[this.index], this.wArray[this.index], this.hArray[this.index]));
        }

        if (state == 1) {
            this.deltay=this.getY();
            this.y += -vy*time/1000;
            if(this.y-this.deltay<0) {
                this.imageView.setViewport(new Rectangle2D(21, 154, 54, 101));
            } else {
                this.imageView.setViewport(new Rectangle2D(93, 156, 64, 101));
            }
            vy+=time*ay/1000;
            this.setY(this.y);
            this.getImageView().setY(this.getY());
        }

        if (this.y>180){
            this.state = 0 ;
        }

        if (state == 2) {
            this.setY(this.getY() + 7);
            this.getImageView().setY(this.getY());
        }

        try {
            Thread.sleep(60);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }

    void jump(){
        if(this.state==0) {
            this.state = 1;
            vy = vsaut;
        } else{

        }
    }


}

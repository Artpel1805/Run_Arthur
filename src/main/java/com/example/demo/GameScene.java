package com.example.demo;



import javafx.geometry.Rectangle2D;
import javafx.scene.Parent;
import javafx.scene.Scene;

public class GameScene extends Scene {
    private Hero hero=new Hero( "heros.png",-200,200);
    private Camera camera = new Camera(0,50, hero);
    private staticThing bgL = new staticThing(0,0,"desert.png");
    private staticThing bgfirst = new staticThing(0,0,"desert.png");
    private staticThing bgR = new staticThing(0,0,"desert.png");
    private staticThing liveOne = new staticThing(10,10,"heart.png");
    private staticThing liveTwo = new staticThing(50,10,"heart.png");
    private staticThing liveThree = new staticThing(90,10,"heart.png");
    private int numberOfLives;




    public GameScene(Parent parent, double v, double v1, boolean b) {
        super(parent, v, v1, b);
        numberOfLives=3;

        bgL.getImageView().setViewport(new Rectangle2D(camera.getX(), camera.getY(), 600,300));
    }



    /////// Getter
    public staticThing getBgL() {
        return bgL;
    }
    public staticThing getBgR() {
        return bgR;
    }
    public staticThing getBgfirst() {return bgfirst;}
    public Hero getHero() {return hero;};
    public Camera getCameraScene() {return camera;}
    public staticThing getLiveOne() {
        return liveOne;
    }
    public staticThing getLiveTwo() {
        return liveTwo;
    }
    public staticThing getLiveThree() {
        return liveThree;
    }
    public int getNumberOfLives() {
        return numberOfLives;
    }
    //////////////


    public void update(double time){
      bgL.getImageView().setViewport(new Rectangle2D(camera.getX()%800, camera.getY(), 600,300));
      bgR.getImageView().setViewport(new Rectangle2D((camera.getX()%800-800), camera.getY(), 600,300));
      bgfirst.getImageView().setViewport((new Rectangle2D(camera.getX()%800+800, camera.getY(), 600,300)));
    }

}


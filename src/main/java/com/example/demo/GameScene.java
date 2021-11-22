package com.example.demo;



import javafx.geometry.Rectangle2D;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontPosture;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;

public class GameScene extends Scene {
    private Hero hero=new Hero( "heros.png",-200,-200);
    private Pig pig=new Pig("pig.png",900,180);
    private Camera camera = new Camera(0,50, hero);
    private staticThing bgL = new staticThing(0,0,"desert.png");
    private staticThing bgfirst = new staticThing(0,0,"desert.png");
    private staticThing bgR = new staticThing(0,0,"desert.png");
    private staticThing liveOne = new staticThing(10,10,"heart.png");
    private staticThing liveTwo = new staticThing(50,10,"heart.png");
    private staticThing liveThree = new staticThing(90,10,"heart.png");
    private Text text = new Text();
    private int numberOfLives;
    final int invicibleDelay = 4000;
    private int remainIncibility= 0 ;




    public GameScene(Parent parent, double v, double v1, boolean b) {
        super(parent, v, v1, b);
        numberOfLives=3;
        bgL.getImageView().setViewport(new Rectangle2D(camera.getX(), camera.getY(), 600,300));
        text.setY(50);
        text.setX(500);
        text.setFont(Font.font("poppins", FontWeight.BOLD, FontPosture.REGULAR, 40));
        text.setFill(Color.WHEAT);
        text.setStrokeWidth(3);
        text.setStroke(Color.BLACK);
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

    public Pig getPig() {return pig;}

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
    public Text getText() {return text;}

    public void setNumberOfLives(int numberOfLives) {
        this.numberOfLives = numberOfLives;
    }
    //////////////


    public void update(double time) {
        bgL.getImageView().setViewport(new Rectangle2D(camera.getX() % 800, camera.getY(), 600, 300));
        bgR.getImageView().setViewport(new Rectangle2D((camera.getX() % 800 - 800), camera.getY(), 600, 300));
        bgfirst.getImageView().setViewport((new Rectangle2D(camera.getX() % 800 + 800, camera.getY(), 600, 300)));
        text.setText("" + (int)Math.floor((hero.getX()+200)/100));
        if (remainIncibility < 0) {
            hero.setInvicible(false);
            remainIncibility = invicibleDelay ;
        }
        if (hero.isInvicible()) {
            remainIncibility -= 160;
        }
        if (colision(hero, pig)) {
            hero.setInvicible(true);
            if (remainIncibility == invicibleDelay -160) {
                numberOfLives--;
                switch (numberOfLives) {
                    case 0:
                        liveOne.getImageView().setVisible(false);
                        break;
                    case 1:
                        liveTwo.getImageView().setVisible(false);
                        break;
                    case 2:
                        liveThree.getImageView().setVisible(false);
                        break;
                    default:
                        break;
                }
            }
        }
    }

    public boolean colision(Hero hero,Pig pig){
        double xhero = hero.getImageView().getX();
        double yhero = hero.getImageView().getY();
        double xpig = pig.getImageView().getX();
        double ypig = pig.getImageView().getY();

        if((xhero + 60 < xpig)||(xpig+ 120 < xhero)||(yhero + 90 < ypig)||(ypig + 100 < yhero)){
            return (false);
        } else {
            return true;
        }
    }
}


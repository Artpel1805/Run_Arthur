package com.example.demo;

import javafx.animation.AnimationTimer;
import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

import java.io.IOException;

public class Run extends Application {
    private final double frame=16;
    @Override
    public void start(Stage stage) throws IOException {

//        Config
        Group root= new Group();
        Pane pane = new Pane(root);
        GameScene scene = new GameScene(pane, 600, 300,true);
        stage.setTitle("Run Arthur !");
        stage.setScene(scene);
////////////////////

//      // Background /////////////
        root.getChildren().add(scene.getBgfirst().getImageView());
        root.getChildren().add(scene.getBgL().getImageView());
        root.getChildren().add(scene.getBgR().getImageView());
//      ///////////////////////////////////

        //// Lives //////////////
        if(scene.getNumberOfLives()>=1){
            root.getChildren().add(scene.getLiveOne().getImageView());
        }
        if(scene.getNumberOfLives()>=2){
            root.getChildren().add(scene.getLiveTwo().getImageView());
        }
        if(scene.getNumberOfLives()>=3){
            root.getChildren().add(scene.getLiveThree().getImageView());
        }
        /////////////////////


        /// Hero ////
        root.getChildren().add(scene.getHero().getImageView());
        ///////////////



        /// Animation Timer
        AnimationTimer timer = new AnimationTimer() {
            @Override
            public void handle(long time) {

                scene.getHero().update(frame*2);
                scene.getCameraScene().update(frame/1000);
                scene.update(frame/1000);
            }
        };
        /// ///////////



        ///// Jump
        pane.setOnMouseClicked( (event)-> {
            scene.getHero().jump();
                });
        ////////////


        timer.start();
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }
}
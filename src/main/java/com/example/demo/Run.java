package com.example.demo;

import javafx.animation.AnimationTimer;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Group;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Background;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontPosture;
import javafx.scene.text.FontWeight;
import javafx.stage.Stage;

import java.io.IOException;

public class Run extends Application {
    private final double frame=16;
    @Override
    public void start(Stage stage) throws IOException {



        ////////////////////////// Game /////////////
//        Config
        Group root= new Group();
        Pane pane = new Pane(root);
        GameScene scene = new GameScene(pane, 600, 300,true);
        stage.setTitle("Robot Vs Flying Pig");
        stage.setScene(scene);
////////////////////

        ///

//      // Background /////////////
        root.getChildren().add(scene.getBgfirst().getImageView());
        root.getChildren().add(scene.getBgL().getImageView());
        root.getChildren().add(scene.getBgR().getImageView());

//      ///////////////////////////////////

        //// Lives //////////////
        root.getChildren().add(scene.getLiveOne().getImageView());
        root.getChildren().add(scene.getLiveTwo().getImageView());
        root.getChildren().add(scene.getLiveThree().getImageView());
        /////////////////////


        /// Hero ////
        root.getChildren().add(scene.getPig().getImageView());
        root.getChildren().add(scene.getHero().getImageView());
        root.getChildren().add(scene.getText());
        ///////////////

        Image galaxy = new Image(ClassLoader.getSystemResourceAsStream("galaxy.jpg"));
        ImageView galaxyview = new ImageView(galaxy);
        root.getChildren().add(galaxyview);

        ////
        Image logo = new Image(ClassLoader.getSystemResourceAsStream("imageLoad.png"));
        ImageView logoView = new ImageView(logo);
        logoView.setX(150);
        root.getChildren().add(logoView);

        ///////Button ////
        Button start = new Button("Start Game !");
        Button restart = new Button("Restart");

        start.setFont(Font.font("poppins", FontWeight.BOLD, FontPosture.REGULAR,40));
        start.setLayoutX(130);
        start.setLayoutY(200);
        start.setBackground(Background.EMPTY);
        start.setStyle("-fx-text-fill: pink;");
        restart.setFont(Font.font("poppins", FontWeight.BOLD, FontPosture.REGULAR,40));
        restart.setLayoutX(200);
        restart.setLayoutY(200);
        restart.setStyle("-fx-text-fill: grey;");
        root.getChildren().add(start);
        root.getChildren().add(restart);
        restart.setVisible(false);
        //////////

        Image gameOver = new Image(ClassLoader.getSystemResourceAsStream("gameOver.png"));
        ImageView gameOverView = new ImageView(gameOver);
        gameOverView.setVisible(false);
        gameOverView.setY(50);
        gameOverView.setX(50);
        root.getChildren().add(gameOverView);

        /// Animation Timer
        AnimationTimer timer = new AnimationTimer() {
            @Override
            public void handle(long time) {
                scene.getPig().update(frame*6);
                scene.getHero().update(frame*2);
                scene.getCameraScene().update(frame/1000);
                scene.update(frame/1000);
                if(scene.getNumberOfLives()==0){
                    this.stop();
                    scene.getHero().getImageView().setVisible(false);
                    scene.getPig().getImageView().setVisible(false);
                    gameOverView.setVisible(true);
                    restart.setVisible(true);
                }
            }
        };
        /// ///////////


        ///// Jump
        pane.setOnMouseClicked( (event)-> {
            scene.getHero().jump();
                });
        ////////////

        // Start //
        start.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                timer.start();
                start.setVisible(false);
                logoView.setVisible(false);
                galaxyview.setVisible(false);
            }
        });

        restart.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
              scene.getHero().setX(-200);
              scene.getHero().setY(-200);
              scene.getHero().getImageView().setX(-200);
              scene.getHero().getImageView().setY(-200);
              timer.start();
              scene.getHero().getImageView().setVisible(true);
              scene.getPig().getImageView().setVisible(true);
              scene.getPig().getImageView().setX(900);
              scene.getPig().setX(900);
              gameOverView.setVisible(false);
              scene.setNumberOfLives(3);
              scene.getCameraScene().setX(0);
              scene.getCameraScene().setY(50);
              scene.getCameraScene().setX(0);
              scene.getCameraScene().setY(50);
              restart.setVisible(false);
              scene.getLiveOne().getImageView().setVisible(true);
              scene.getLiveTwo().getImageView().setVisible(true);
              scene.getLiveThree().getImageView().setVisible(true);
            }
        });
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }
}
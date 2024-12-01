package com.example.assignment2api;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Stage;

public class Main extends Application {

    @Override
    public void start(Stage stage) throws Exception {
        FXMLLoader fxmlLoader = new FXMLLoader(Main.class.getResource("search-card-view.fxml"));
        Scene scene = new Scene(fxmlLoader.load());
        stage.setTitle("Search Magic The Gathering Cards!");
        stage.getIcons().add(new Image(getClass().getResourceAsStream("images/logo.png")));
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) { launch(); }
}

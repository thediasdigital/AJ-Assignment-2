package com.example.assignment2api;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class SceneManager {

    public static void ShowDetails (ActionEvent event, Card card) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(Main.class.getResource("card-details-view.fxml"));
        Scene scene = new Scene(fxmlLoader.load());

        // Pass the selected card to the details controller
        CardDetailsViewController controller = fxmlLoader.getController();
        controller.GrabCard(card);

        // Gets the same stage instance and switch scenes
        Stage stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        stage.setTitle("Details: " + card.getName());
        stage.setScene(scene);
        stage.show();
    }

    public static void ChangeToSearch (ActionEvent event) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(Main.class.getResource("search-card-view.fxml"));
        Scene scene = new Scene(fxmlLoader.load());
        Stage stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        stage.setTitle("Search Magic The Gathering Cards!");
        stage.setScene(scene);
        stage.show();
    }
}

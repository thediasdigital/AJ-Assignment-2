package com.example.assignment2api;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.ListView;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;

public class SearchCardViewController {

    @FXML
    private Button getDetailsBtn;

    @FXML
    private ListView<Card> resultsListView;

    @FXML
    private Button searchBtn;

    @FXML
    private TextField searchTxtField;

    @FXML
    void getResults(ActionEvent event) {

        resultsListView.getItems().clear();
        resultsListView.getItems().addAll(ApiUtility.searchCards(searchTxtField.getText()));

    }

}

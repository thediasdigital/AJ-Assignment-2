package com.example.assignment2api;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;

public class SearchCardViewController {

    @FXML
    private Button getDetailsBtn;

    @FXML
    private ListView<Card> resultsListView;

    @FXML
    private Button searchBtn;

    @FXML
    private TextField searchTxtField;

    // Color check boxes
    @FXML
    private CheckBox chkBlack;

    @FXML
    private CheckBox chkBlue;

    @FXML
    private CheckBox chkGreen;

    @FXML
    private CheckBox chkRed;

    @FXML
    private CheckBox chkWhite;

    // Search type radio buttons
    @FXML
    private RadioButton radioName;

    @FXML
    private RadioButton radioText;

    @FXML
    private RadioButton radioType;


    @FXML
    void getResults(ActionEvent event) {

        resultsListView.getItems().clear();
        resultsListView.getItems().addAll(ApiUtility.searchCards(searchTxtField.getText()));

    }
}

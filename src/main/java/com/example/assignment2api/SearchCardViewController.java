package com.example.assignment2api;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.*;

import java.io.IOException;
import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;

public class SearchCardViewController implements Initializable {

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
    private ToggleGroup searchby;

    @FXML
    private RadioButton radioName;

    @FXML
    private RadioButton radioText;

    @FXML
    private RadioButton radioType;

    @FXML
    private Label warningLabel;


    @FXML
    void getResults(ActionEvent event) {
        StringBuilder searchConditions = new StringBuilder();

        // Change the query based on radio buttons of what to search by
        if(radioName.isSelected()) {
            searchConditions.append("&name=").append(searchTxtField.getText());
        }
        else if(radioText.isSelected()) {
            searchConditions.append("&text=").append(searchTxtField.getText());
        }
        else if(radioType.isSelected()) {
            searchConditions.append("&type=").append(searchTxtField.getText());
        }

        // Add to query for color identity
        searchConditions.append("&colors=");
        // Create a list of the checkboxes to make it easier to check if any are selected
        List<CheckBox> manaCheckBoxes = List.of(chkWhite, chkBlack, chkBlue, chkGreen, chkRed);
        // If any check boxes are selected add that color to the search
        if(manaCheckBoxes.stream().anyMatch(CheckBox::isSelected)) {
            if(chkWhite.isSelected()) {
                searchConditions.append("w,");
            }
            if(chkBlue.isSelected()) {
                searchConditions.append("u,");
            }
            if(chkBlack.isSelected()) {
                searchConditions.append("b,");
            }
            if(chkRed.isSelected()) {
                searchConditions.append("r,");
            }
            if(chkGreen.isSelected()) {
                searchConditions.append("g,");
            }
        }
        // Clear the list view of previous content
        resultsListView.getItems().clear();
        // Add the list of items based on the search conditions
        resultsListView.getItems().addAll(ApiUtility.searchCards(searchConditions.toString()));
    }

    @FXML
    void loadDetails(ActionEvent event) throws IOException {
        Card currCard = resultsListView.getSelectionModel().getSelectedItem();
        if(currCard != null) {
            SceneManager.ShowDetails(event, currCard);
        }
        else {
            warningLabel.setText("No card selected");
        }
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        radioName.setSelected(true);
    }
}

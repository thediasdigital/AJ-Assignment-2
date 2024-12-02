package com.example.assignment2api;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.web.WebView;

import java.io.IOException;

public class CardDetailsViewController {

    @FXML
    private WebView cardArt;

    @FXML
    private Label cardName;

    @FXML
    private Label manaText;

    @FXML
    private Label powerText;

    @FXML
    private Label rarityText;

    @FXML
    private Label rulesText;

    @FXML
    private Label setText;

    @FXML
    private Label typeText;

    public void GrabCard(Card card) {
        cardName.setText(card.getName());
        manaText.setText(card.getManaCost() + " (" + card.getCmc() + " cmc)" );
        typeText.setText(card.getType());
        setText.setText(card.getSetName() + " (" + card.getSet() + ")");
        rarityText.setText(card.getRarity());
        powerText.setText(card.getPower() + " / " + card.getToughness());
        rulesText.setText(card.getText());
        cardArt.getEngine().load(card.getImageUrl());
    }

    @FXML
    void backToSearch(ActionEvent event) throws IOException {
        SceneManager.ChangeToSearch(event);
    }
}

package com.example.assignment2api;

import javafx.fxml.FXML;
import javafx.scene.control.Label;

public class CardDetailsViewController {

    @FXML
    private Label cardName;

    public void GrabCard(Card card) {
        cardName.setText(card.getName());
    }
}

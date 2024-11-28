package com.example.assignment2api;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.ArrayList;
import java.util.List;

public class ApiUtility {

    /**
     * This function returns a list of card objects returned from the MTG api
     * based on the results of the search keywords.
     *
     * @param condition - What keywords the user enters into the search bar
     * @return
     */
    public static List<Card> searchCards(String condition) {
        // Modify the condition string so that if there are spaces they become "+"
        condition = condition.replaceAll(" ", "+");

        // Create a list of cards to return
        List<Card> cards = new ArrayList<>();

        // Create the search string and append the condition
        // (For now the search is only by name for testing. I will update to allow to search by
        // different fields of a card)
        StringBuilder searchUrl = new StringBuilder("https://api.magicthegathering.io/v1/cards?");
        searchUrl.append(condition);

        try {
            // Create the client and request objects
            HttpClient client = HttpClient.newHttpClient();
            HttpRequest request = HttpRequest.newBuilder()
                    .uri(new URI(searchUrl.toString()))
                    .GET()
                    .build();

            // Send the request and get the response as a String
            HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());

            // Ensure the response is valid
            if(response.statusCode() == 200) {
                Gson gson = new Gson();
                // Deserialize the results from the response
                CardList cardList = gson.fromJson(response.body(), CardList.class);
                // Add the results to the cards list
                cards.addAll(cardList.getCards());
            }
            else {
                System.out.println("Invalid response from api");
            }

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

        return cards;
    }

}
module com.example.assignment2api {
    requires javafx.controls;
    requires javafx.fxml;
    requires com.google.gson;
    requires java.net.http;


    opens com.example.assignment2api to javafx.fxml;
    exports com.example.assignment2api;
}
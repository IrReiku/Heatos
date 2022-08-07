module com.example.heatos {
    requires javafx.controls;
    requires javafx.fxml;
    requires org.junit.jupiter.api;


    opens com.example.heatos to javafx.fxml;
    exports com.example.heatos;
    exports com.example.heatos.model;
    opens com.example.heatos.model to javafx.fxml;
    exports com.example.heatos.controller;
    opens com.example.heatos.controller to javafx.fxml;
}
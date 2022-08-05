package com.example.heatos.controller;

import com.example.heatos.Heatos;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;

import java.io.IOException;

public class HelloController {
    @FXML
    private Button playButton;
    @FXML
    public void showMenu() throws IOException {
        Stage stage = (Stage) playButton.getScene().getWindow();
        FXMLLoader fxmlLoader = new FXMLLoader(Heatos.class.getResource("menu-view.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 600, 600);
        stage.setScene(scene);
    }

    public void showRules() throws IOException {
        Stage stage = (Stage) playButton.getScene().getWindow();
        FXMLLoader fxmlLoader = new FXMLLoader(Heatos.class.getResource("rules-view.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 600, 600);
        stage.setScene(scene);
    }
}
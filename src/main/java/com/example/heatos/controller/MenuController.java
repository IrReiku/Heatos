package com.example.heatos.controller;

import com.example.heatos.Heatos;
import com.example.heatos.model.Field;
import com.example.heatos.model.MultiplyBlock;
import com.example.heatos.model.StoneBlock;
import com.example.heatos.model.TemperatureBlock;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.FlowPane;
import javafx.stage.Stage;

import java.io.IOException;

public class MenuController {
    @FXML
    public FlowPane buttonPane;

    @FXML
    private Button backButton;

    @FXML
    public void showHello() throws IOException {
        Stage stage = (Stage) backButton.getScene().getWindow();
        FXMLLoader fxmlLoader = new FXMLLoader(Heatos.class.getResource("hello-view.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 600, 600);
        stage.setScene(scene);
    }

    @FXML
    public void level1 () throws IOException {
        FXMLLoader fxmlLoader = showLevel();
        LevelController controller = fxmlLoader.getController();
        controller.setLvl(1);
        Field field = new Field(5);
        field.addBlock(0, 0, "3");
        field.addBlock(0, 4, "3");
        field.addBlock(4, 0,"3");
        field.addBlock(4, 4, "3");
        field.addBlock(1, 2, "-3");
        field.addBlock(3, 2, "-3");
        controller.setField(field);
    }


    public FXMLLoader showLevel() throws IOException {
        Stage stage = (Stage) backButton.getScene().getWindow();
        FXMLLoader fxmlLoader = new FXMLLoader(Heatos.class.getResource("level-sample.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 600, 600);
        stage.setScene(scene);
        return fxmlLoader;
    }

    public void level2() throws IOException {
        FXMLLoader fxmlLoader = showLevel();
        LevelController controller = fxmlLoader.getController();
        controller.setLvl(2);
        Field field = new Field(3);
        field.addBlock(0, 0, "3");
        field.addBlock(0, 1, "s");
        field.addBlock(0, 2, "3");
        field.addBlock(1, 0, new TemperatureBlock(-2, 1, 0));
        field.addBlock(1, 1, new TemperatureBlock(-5, 1, 1));
        field.addBlock(1, 2, new TemperatureBlock(-3, 1, 2));
        field.addBlock(2, 0, new TemperatureBlock(2, 2, 0));
        field.addBlock(2, 1, new StoneBlock(2, 1));
        field.addBlock(2, 2, new TemperatureBlock(2, 2, 2));
        controller.setField(field);
    }

    public void level3() throws IOException {
        FXMLLoader fxmlLoader = showLevel();
        LevelController controller = fxmlLoader.getController();
        controller.setLvl(3);
        Field field = new Field(4);
        field.addBlock(0, 1, new TemperatureBlock(2, 0, 1));
        field.addBlock(0, 2, new TemperatureBlock(-4,0,2));
        field.addBlock(0, 3, new TemperatureBlock(1, 0, 3));
        field.addBlock(1, 1, "*2");
        field.addBlock(1, 3, new TemperatureBlock(-9, 1, 3));
        field.addBlock(2, 2, new MultiplyBlock(2, 2, 2));
        field.addBlock(2, 3, new TemperatureBlock(2, 2, 3));
        field.addBlock(3, 0, new TemperatureBlock(3, 3, 0));
        controller.setField(field);
    }
}

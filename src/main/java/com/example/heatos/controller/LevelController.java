package com.example.heatos.controller;

import com.example.heatos.Heatos;
import com.example.heatos.model.*;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.geometry.HPos;
import javafx.geometry.VPos;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.effect.DropShadow;
import javafx.scene.layout.ColumnConstraints;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.RowConstraints;
import javafx.scene.paint.Color;
import javafx.scene.paint.Paint;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Font;
import javafx.stage.Stage;

import java.io.IOException;

public class LevelController {
    @FXML
    public GridPane gridPane;
    @FXML
    public Label levelName;

    public int lvl;
    public Field field;
    public Field startField;
    public Label endGameLabel;
    Boolean selectedExists = false;


    public void showMenu() throws IOException {
        Stage stage = (Stage) gridPane.getScene().getWindow();
        FXMLLoader fxmlLoader = new FXMLLoader(Heatos.class.getResource("menu-view.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 600, 600);
        stage.setScene(scene);
    }

    public void setLvl(int lvl) {
        this.lvl = lvl;
        levelName.setText("Уровень " + lvl);
    }

    public void setField(Field field) {
        this.field = new Field(field);
        this.startField = new Field(field);
        drawField();
    }

    private double resizeGrid() {
        while (gridPane.getRowCount() != field.size) {
            int index = gridPane.getRowCount();
            ColumnConstraints column = new ColumnConstraints(index);
            RowConstraints row = new RowConstraints(index);
            column.setHalignment(HPos.CENTER);
            row.setValignment(VPos.CENTER);
            gridPane.getColumnConstraints().add(column);
            gridPane.getRowConstraints().add(row);
        }
        double cellSize = gridPane.getWidth()/field.size;
        gridPane.getColumnConstraints().forEach(columnConstraints -> columnConstraints.setPrefWidth(cellSize));
        gridPane.getRowConstraints().forEach(rowConstraints -> rowConstraints.setPrefHeight(cellSize));
        return cellSize;
    }

    public void drawField() {
        gridPane.getChildren().clear();

        double cellSize = resizeGrid();

        for (int x = 0; x < field.size; x++) {
            for (int y = 0; y < field.size; y++) {
                Block block = field.getBlock(x, y);
                Rectangle rectangle = new Rectangle();
                Label label = new Label();
                label.getStyleClass().clear();
                label.getStyleClass().add("blockLabel");
                label.setFont(new Font(cellSize*0.40));
                Rectangle clickPane = new Rectangle();
                clickPane.setFill(Paint.valueOf("transparent"));
                clickPane.setWidth(cellSize);
                clickPane.setHeight(cellSize);

                if (block instanceof TemperatureBlock) {

                    int blockTemperature = ((TemperatureBlock) block).temperature;
                    label.setText(Integer.toString(blockTemperature));
                    if (blockTemperature > 0) {
                        rectangle.getStyleClass().add("warmBlock");
                    } else if (blockTemperature < 0) {
                        rectangle.getStyleClass().add("coldBlock");
                    } else {
                        rectangle.setFill(Paint.valueOf("transparent"));
                        label.setVisible(false);
                    }

                } else if (block instanceof MultiplyBlock) {
                    label.getStyleClass().add("multiplyBlockLabel");
                    label.setText("×"+ ((MultiplyBlock) block).index);
                    rectangle.getStyleClass().add("multiplyBlock");
                } else if (block instanceof StoneBlock) {
                    rectangle.getStyleClass().add("stoneBlock");
                }

                clickPane.setOnMouseClicked(event -> {
                    int rectX = GridPane.getColumnIndex(rectangle);
                    int rectY = GridPane.getRowIndex(rectangle);
                    if (field.getBlock(rectX, rectY) instanceof TemperatureBlock) {
                        if (!selectedExists && ((TemperatureBlock) field.getBlock(rectX, rectY)).temperature != 0) {
                            DropShadow shadow = new DropShadow();
                            shadow.setSpread(0.3);
                            shadow.setColor(new Color(0.1804, 0.0471, 0.2118, 1.0));
                            rectangle.setEffect(shadow);
                            field.setSelectedBlock((TemperatureBlock) field.getBlock(rectX, rectY));
                            selectedExists = true;
                        } else if (selectedExists) {
                            field.move(rectX, rectY);
                            if (field.winCheck()){
                                endGame();
                            }
                            selectedExists = false;
                            drawField();
                        }
                    } else if (field.getBlock(rectX, rectY) instanceof MultiplyBlock && selectedExists) {
                        field.move(rectX, rectY);
                        if (field.winCheck()){
                            endGame();
                        }
                        selectedExists = false;
                        drawField();
                    }
                });
                rectangle.setWidth(cellSize*0.85);
                rectangle.setHeight(rectangle.getWidth());
                Rectangle gridLine = new Rectangle();
                gridLine.getStyleClass().add("gridLine");
                gridLine.setWidth(cellSize);
                gridLine.setHeight(cellSize);
                gridPane.add(gridLine, x, y);
                gridPane.add(rectangle, x, y);
                gridPane.add(label, x, y);
                gridPane.add(clickPane, x, y);
            }
        }
    }

    public void endGame() {
        gridPane.setVisible(false);
        selectedExists = false;
        endGameLabel.setVisible(true);
    }

    public void restart() {
        gridPane.setVisible(true);
        endGameLabel.setVisible(false);
        field = new Field(startField);
        selectedExists = false;
        drawField();
    }
}
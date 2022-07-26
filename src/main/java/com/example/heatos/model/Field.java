package com.example.heatos.model;

import com.example.heatos.controller.LevelController;

public class Field {
    public int size;
    Block[][] matrix;
    TemperatureBlock selectedBlock;


    public Field (int size) {
        this.size = size;
        matrix = new Block[size][size];

        for (int x = 0; x < size; x++) {
            for (int y = 0; y < size; y++) {
                matrix[y][x] = new TemperatureBlock(0, x, y);
            }
        }
    }

    public void setSelectedBlock(TemperatureBlock block) {
        this.selectedBlock = block;
    }

    public void addBlock(int x, int y, Block block) {
        matrix[y][x] = block;
    }

    public Block getBlock(int x, int y) {
        return matrix[y][x];
    }

    public void move(int x, int y) {
        Block destinationBlock = matrix[y][x];
        if (!(destinationBlock instanceof StoneBlock) &&
            (x == selectedBlock.x && y == selectedBlock.y + 1 ||
            x == selectedBlock.x + 1 && y == selectedBlock.y ||
            x == selectedBlock.x && y == selectedBlock.y - 1 ||
            x == selectedBlock.x - 1 && y == selectedBlock.y )) {

            matrix[selectedBlock.y][selectedBlock.x] = new TemperatureBlock(selectedBlock.x, selectedBlock.y);
            int newTemperature = 0;
            if (destinationBlock instanceof TemperatureBlock) {
                if (((TemperatureBlock) destinationBlock).temperature >= 0 || selectedBlock.temperature > 0) {
                    if (((TemperatureBlock) destinationBlock).temperature == 0) {
                    newTemperature = selectedBlock.temperature - 1;
                    } else {
                    newTemperature = selectedBlock.temperature + ((TemperatureBlock) destinationBlock).temperature;
                }
            }
            } else if (destinationBlock instanceof MultiplyBlock) {
                newTemperature = selectedBlock.temperature * ((MultiplyBlock) destinationBlock).index;
            }
            matrix[y][x] = new TemperatureBlock(newTemperature, x, y);
        }
    }

    public boolean winCheck() {
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                if (matrix[i][j] instanceof TemperatureBlock && ((TemperatureBlock) matrix[i][j]).temperature != 0)
                    return false;
            }
        }
        return true;
    }
}

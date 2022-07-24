package com.example.heatos.model;

public class Field {
    int size;
    int[][] matrix;
    public Block selected;

    public Field (int size) {
        this.size = size;
        matrix = new int[size][size];

        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                matrix[i][j] = 0;
            }
        }
    }

    public Field (int[][] matrix) {
        this.matrix = matrix;
        this.size = matrix.length;
    }

    public void addBlock(int x, int y, Block block) {
        matrix[y][x] = block.temperature;
    }

    public void move(Block block, String direction) {
        matrix[block.y][block.x] = 0;

        switch (direction) {
            case "up":
                block.y -= 1;
                break;
            case "down":
                block.y += 1;
                break;
            case "left":
                block.x -= 1;
                break;
            case "right":
                block.x += 1;
                break;
        }

        if (matrix[block.y][block.x] == 0) block.temperature -= 1;
        else block.temperature += matrix[block.y][block.x];
        matrix[block.y][block.x] = block.temperature;
    }

    public boolean winCheck() {
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                if (matrix[i][j] != 0) return false;
            }
        }
        return true;
    }

    public void setSelected(Block block) {
        selected = block;
    }
}

package com.example.heatos.model;

public abstract class Block {
    int x;
    int y;
    public Block(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public Block(Block block) {
        this.x = block.x;
        this.y = block.y;
    }
}

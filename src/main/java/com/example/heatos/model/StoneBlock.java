package com.example.heatos.model;

public class StoneBlock extends Block{
    public StoneBlock(int x, int y) {
        super(x, y);
    }

    public StoneBlock(StoneBlock block) {
        super(block.x, block.y);
    }

}

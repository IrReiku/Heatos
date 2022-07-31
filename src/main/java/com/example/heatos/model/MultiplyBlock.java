package com.example.heatos.model;

public class MultiplyBlock extends Block{
    public int index;

    public MultiplyBlock(int index, int x, int y) {
        super(x, y);
        this.index = index;
    }
    public MultiplyBlock(MultiplyBlock block) {
        super(block.x, block.y);
        this.index = block.index;
    }
}

package com.example.heatos.model;

import java.util.Objects;

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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        MultiplyBlock that = (MultiplyBlock) o;
        return index == that.index;
    }

    @Override
    public int hashCode() {
        return Objects.hash(index);
    }
}

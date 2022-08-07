package com.example.heatos.model;

import java.util.Objects;

public class TemperatureBlock extends Block {
    public int temperature;

    public TemperatureBlock(int temperature, int x, int y) {
        super(x, y);
        this.temperature = temperature;
    }
    public TemperatureBlock(int x, int y) {
        super(x, y);
        this.temperature = 0;
    }
    public TemperatureBlock(TemperatureBlock block) {
        super(block.x, block.y);
        this.temperature = block.temperature;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        TemperatureBlock that = (TemperatureBlock) o;
        return temperature == that.temperature;
    }

    @Override
    public int hashCode() {
        return Objects.hash(temperature);
    }
}

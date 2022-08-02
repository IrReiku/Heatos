package com.example.heatos.model;

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

}

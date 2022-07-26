package com.example.heatos.model;

public class TemperatureBlock extends Block {
    boolean movable = true;
    boolean receiving = true;
    public int temperature;

    public TemperatureBlock(int temperature, int x, int y) {
        super(x, y);
        this.temperature = temperature;
    }
    public TemperatureBlock(int x, int y) {
        super(x, y);
        this.temperature = 0;
    }
}

package org.example;

import java.util.Random;

public class RandomDie extends Die{

    private int value;

    public RandomDie() {
        value = new Random().nextInt(1, 7);
    }

    @Override
    int getValue() {
        return value;
    }
}

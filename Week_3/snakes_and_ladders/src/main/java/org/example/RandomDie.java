package org.example;

import java.util.Random;

public class RandomDie extends Die {

    public RandomDie() {
        super(new Random().nextInt(1, 7));
    }

}

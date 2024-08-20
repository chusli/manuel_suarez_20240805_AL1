package org.example;

import java.util.Random;

public class RandomDie extends Die{

    boolean hasBeenAccessed = false;
    @Override
    int getValue() {
       if(hasBeenAccessed){
           throw new IllegalStateException();
       }
        hasBeenAccessed = true;
        return new Random().nextInt(1, 7);
    }
}

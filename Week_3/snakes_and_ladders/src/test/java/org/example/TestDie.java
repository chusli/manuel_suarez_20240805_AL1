package org.example;

public class TestDie extends Die {

    private final int value;

    public TestDie(int value) {
        this.value = value;
    }

    @Override
    int getValue() {
        return value;
    }

}

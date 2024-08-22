package org.example;

import java.util.Objects;

public abstract class Die {

    protected final int value;

    public Die(int value) {
        this.value = value;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Die die = (Die) o;
        return value == die.value;
    }

    @Override
    public int hashCode() {
        return Objects.hash(value);
    }

    public int getValue() {
        return value;
    }

    public int add(Die die) {
        return value + die.getValue();
    }

}

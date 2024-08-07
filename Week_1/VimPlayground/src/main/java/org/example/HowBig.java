package org.example;

public class HowBig {
    public static int is(int i) {
        if (i==0) return 1;
        int result = 0;
        while (Math.pow(2, result) <= i) {
            result++;
        }
        return result;
    }
}

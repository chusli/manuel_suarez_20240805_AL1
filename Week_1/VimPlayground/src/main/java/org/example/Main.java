package org.example;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        System.out.println("Enter a positive integer: ");
        Scanner sc = new Scanner(System.in);
        int input = sc.nextInt();

        int binaryDigits = HowBig.is(input);
        System.out.println("Binary digits: " + binaryDigits);
        System.out.println(Integer.toBinaryString(input));
    }
}

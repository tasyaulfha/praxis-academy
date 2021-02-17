package com.praxisacadamy.jutiprojects;

public class Calculator {
    public static int add(int number, int number2) {
        return number + number2;
    }

    public static int sub(int number, int number2) {
        return number - number2;
    }

    public static int mul(int number, int number2) {
        return number * number2;
    }

    public static double div(double number, double number2) {
        if (number2==0){
            throw new IllegalArgumentException("number can't divide by 0 ")
        }
        return number2 / number;
    }
}

package com.volkodav4ik;

import java.lang.reflect.Method;

public class Main {
    private static final int A = 10;
    private static final int B = 8;
    private static Calculator calc = new Calculator();

    public static void main(String[] args) {

        int sum = calc.sum(A, B);
        int subt = calc.subtraction(A, B);
        double mult = calc.multiplication(A, B);
        double div = calc.division(A, B);
        System.out.printf("Summ = %d\nSubtraction = %d\nMultiplication = %.2f\nDivision = %.2f\n", sum, subt, mult, div);
        System.out.printf("Try to get method from class: %.2f", getMethod("division"));
    }

    private static double getMethod(String s) {
        double c = 0;
        try {
            Method method = calc.getClass().getMethod(s, int.class, int.class);
            c = (double) method.invoke(calc, A, B);
        } catch (Exception e) {
            System.out.println("There is no method " + s + " in this class");
        }
        return c;
    }
}

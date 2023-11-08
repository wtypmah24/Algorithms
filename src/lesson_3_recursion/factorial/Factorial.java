package lesson_3_recursion.factorial;

import java.util.ArrayList;

public class Factorial {
    public static void main(String[] args) {
        System.out.println(getFactorial(5));
        System.out.println(getFibonacci(5));
    }

    public static int getFactorial(int n) {
        if (n == 1 || n == 0)return 1;
        return n * getFactorial(n - 1);
    }

    public static int getFibonacci(int n) {
        if (n <= 0) {
            return 0;
        } else if (n == 1) {
            return 1;
        } else {
            return getFibonacci(n - 1) + getFibonacci(n - 2);
        }
    }
}

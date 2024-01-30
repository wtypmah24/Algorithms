package HW_31012024;

import java.util.Arrays;

public class BubbleSort {
    public static void main(String[] args) {
        int[] ints = {3, 24, 5, 4, 6, 75, 4, 3, 2};
        sortBubble(ints);
        System.out.println(Arrays.toString(ints));

    }

    private static void sortBubble(int[] input) {
        for (int i = 0; i < input.length; i++) {
            for (int j = i + 1; j < input.length; j++) {
                if (input[i] > input[j]) {
                    int tmp = input[i];
                    input[i] = input[j];
                    input[j] = tmp;
                }
            }
        }
    }
}

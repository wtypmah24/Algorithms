package lesson_2.o.notation;

public class BigONotation {
    public static void main(String[] args) {
        int[] data = new int[]{1, 3, 5, 12};
        processData(data);
    }

    // n * n = n^2
    //best case = worst case O(n^2)
    private static void processData(int[] data) {
        for (int i = 0; i < data.length; i++) {
            System.out.println("Processing" + data[i]);
            int count = 0;
            for (int j = 0; j < data.length; j++) {
                count = count + data[i];
            }
        }
    }

    // O(3) = O(1)
    public static int sum(int a, int b) {
        int result = a + b; //2 action
        return result; //1 action
    }

    // 5n + 5 = 5 * (n + 1) = n
    public static int sumArray(int[] arr) {
        int sum = 0; //1
        for (int i : arr) { //3 * (n+1)
            sum += i; // 2 * n
        }
        return sum; // 1
    }
}
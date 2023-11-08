package lesson_3_recursion.task_1;

public class RecursiveSum {
    public static void main(String[] args) {
        int [] data = {2,32,7,63,4,87};
        System.out.println(sumRecursive(data, 0));
    }

    public static int sumRecursive(int[] data, int currentIndex) {
        if (currentIndex == data.length) return 0;
        int sum = data[currentIndex] + sumRecursive(data, currentIndex + 1);
        return sum;
    }
}

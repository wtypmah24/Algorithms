package lesson_3_recursion.task_2;

public class SumSequence {
    public static void main(String[] args) {
        System.out.println(sumRecursive(5));
    }

    public static int sumRecursive(int num) {
        if (num == 1) return 1; //base condition
        return num + sumRecursive(num - 1);
    }
}
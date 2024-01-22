package devide_conq;

public class Main {
    public static void main(String[] args) {
        int[] array = {1, 2, 3, 4, 5};
        int sum = divideAndConquerSum(array, 0, array.length - 1);
        System.out.println("Сумма элементов массива: " + sum);
    }

    private static int divideAndConquerSum(int[] array, int left, int right) {
        if (left == right) {
            return array[left];
        } else {
            int middle = (left + right) / 2;

            int leftSum = divideAndConquerSum(array, left, middle);
            int rightSum = divideAndConquerSum(array, middle + 1, right);

            return leftSum + rightSum;
        }
    }
}
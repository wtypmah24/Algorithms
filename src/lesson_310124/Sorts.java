package lesson_310124;

public class Sorts {
    /*Task 1. Найти k-ый по величине элемент неотсортированного массива.
    Входные данные: Integer[] data = {1, 3, 1, 5, 0, 7, 8};
    Результат:
    k = 0
    findSmallest(data, k)=0 (min)
    k = 1
    Результат: findSmallest(data, k)=1
    k = 6
    Результат: findSmallest(data, k)=8 (max)*/
    public static void main(String[] args) {
        int[] ints = {3,4,87,2,34,6,5,12,374,52,1,3};
        System.out.println(quickSelect(ints, 1));


    }
    public static int quickSelect(int[] arr, int k) {
        if (arr == null || k < 0 || k >= arr.length) {
            throw new IllegalArgumentException("Некорректные входные данные");
        }

        return quickSelectHelper(arr, 0, arr.length - 1, k);
    }

    private static int quickSelectHelper(int[] arr, int low, int high, int k) {
        if (low == high) {
            return arr[low];
        }

        // Выбираем опорный элемент и проводим разделение
        int pivotIndex = partition(arr, low, high);

        // Если k равно индексу опорного элемента, возвращаем его значение
        if (k == pivotIndex) {
            return arr[pivotIndex];
        }
        // Если k меньше индекса опорного элемента, ищем в левой части
        else if (k < pivotIndex) {
            return quickSelectHelper(arr, low, pivotIndex - 1, k);
        }
        // Иначе ищем в правой части
        else {
            return quickSelectHelper(arr, pivotIndex + 1, high, k);
        }
    }

    private static int partition(int[] arr, int low, int high) {
        int pivot = arr[high];
        int i = low - 1;

        for (int j = low; j < high; j++) {
            if (arr[j] <= pivot) {
                i++;
                swap(arr, i, j);
            }
        }

        swap(arr, i + 1, high);
        return i + 1;
    }

    private static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}

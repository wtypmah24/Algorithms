package HW_100124;

import HW_131223.SearchTree;

import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

public class CompareArrays {

    //      Task: Проверьте, равны ли два массива или нет
//     Учитывая два массива, arr1 и arr2, одинаковой длины N, задача состоит в том, чтобы определить,
//     равны ли данные массивы или нет.
//
//     Два массива называются равными, если:
//     оба они содержат один и тот же набор элементов,
//     расположение (или перестановки) элементов может/не может быть одинаковым.
//     Если есть повторения, то количество повторяющихся элементов также должно быть одинаковым,
//     чтобы два массива были равны.
//
//    Ввод: arr1[] = {1, 2, 5, 4, 0, 0}, arr2[] = {0, 2, 4, 5, 0, 1}
//    Вывод: Да
    public static void main(String[] args) {
        int[] array1 = {1, 2, 1, 3};
        int[] array2 = {3, 2, 1, 2};
        System.out.println(isEqual(array1, array2));

        System.out.println(areArraysEqual(array1, array2));
    }

    public static boolean isEqual(int[] array1, int[] array2) {  // O(n log n)
        Arrays.sort(array1); // O(n log n)
        Arrays.sort(array2); // O(n log n)
        return Arrays.equals(array1, array2); // O(n)
    }


    public static boolean areArraysEqual(int[] array1, int[] array2) {
        if (array1.length != array2.length) {
            return false;
        }

        HashMap<Integer, Integer> numberToFrequency = new HashMap<>();

        for (int num : array1) { // O(n)
            numberToFrequency.put(num, numberToFrequency.getOrDefault(num, 0) + 1);//O(1)
        }
        //Если число не присутствует в HashMap возвращаем false.
        for (int num : array2) { //O(n)
            int frequency = numberToFrequency.getOrDefault(num, 0);  //O(1)
            if (frequency == 0) {
                return false;
            }
            //Учитываем колличество повторов.
            numberToFrequency.put(num, frequency - 1); //O(1)
        }

        return true;
    }
}

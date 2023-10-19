package HW_181023;

public class Task_1 {
    /*  1 уровень сложности: Дан отсортированный массив, в котором все элементы встречаются дважды (один за другим),
    а один элемент появляется только один раз.
    Написать метод для нахождения этого элемента.
    Решить задачу через простой цикл
    2*. через адаптацию алгоритма бинарного поиска
    */
    public static void main(String[] args) {
        int[] arr = {1,1, 2, 2, 3, 3, 4, 4, 5, 5, 6, 6, 7, 7, 8, 9, 9, 10, 10, 11, 11};
        System.out.println(binaryGetUniqueElem(arr));
        System.out.println(getUniqueElem(arr));

    }
    public static int binaryGetUniqueElem(int[] arr) {
        int left = 0;
        int right = arr.length - 1;

        while (left < right) {
            int mid = left + (right - left) / 2;

            //Если центральный индекс чётный и эемент массива под центральным индексом равен следующему элементу то уникальный элемент справа,
            //В противном случае  - слева
            if (mid % 2 == 1) {
                mid--;
            }
            if (arr[mid] == arr[mid + 1]) {
                left = mid + 2;
            } else {
                right = mid;
            }
        }

        return arr[left];
    }
    //1,2,3,3,4,4,5,5,6,6,7,7,8,8 ,9,9   //17

    public static int getUniqueElem(int[] arr){
        for (int i = 0; i < arr.length; i+=2) {
            if(arr[i] != arr[i+1]){
                return arr[i];
            }
        }
        return -1;
    }
}

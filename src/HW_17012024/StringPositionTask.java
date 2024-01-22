package HW_17012024;

public class StringPositionTask {
    /*
    * Имеется отсортированный массив строк, в котором могут присутствовать
    пустые строки. Напишите метод для определения позиции заданной строки.
    Пример:
    Ввод: строка "ball" в массиве {"at", "", "", "", "ball" , "", "" ," car" , '"', "",
    "dad", ,, .., ""}
    Вывод: 4*/

    public static void main(String[] args) {
        String[] strings = {"at", "", "", "", "ball", "", "", "", "", "", "car", "", "", "dad", ""};
        String target = "ball";

        System.out.println(findStringPosition(target, strings));
    }

    private static int findStringPosition(String target, String[] array) {
        if (array == null || target == null || target.isEmpty()) {
            return -1;
        }

        int left = 0;
        int right = array.length - 1;

        while (left <= right) {
            int mid = left + (right - left) / 2;

            // Находим непустую строку в ближайшем окне (Движемся вправо)
            while (mid <= right && array[mid].isEmpty()) {
                mid++;
            }
            int result = target.compareTo(array[mid]);

            if (result == 0) {
                return mid; // Совпадение найдено
            } else if (result < 0) {
                right = mid - 1; // Искомая строка находится в левой части
            } else {
                left = mid + 1; // Искомая строка находится в правой части
            }
        }

        return -1; // Строка не найдена
    }
}

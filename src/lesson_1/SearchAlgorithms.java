package lesson_1;

public class SearchAlgorithms {
    public static void main(String[] args) {
        String[] data = new String[]{"A", "B", "C", "Hello", "World", "!"};
        System.out.println(searchLinear(data, "K"));
    }

    public static int searchLinear(String[] data, String element) {
        for (int i = 0; i < data.length; i++) {
            if (element.equals(data[i])) {
                return i;
            }
        }
        return -1;
    }
    public static int binarySearch(Integer[] data, int element) {

        int start = 0;
        int end = data.length - 1;
        int mid;

        while (start <= end) {
            mid = start + (end - start) / 2;
            if(element == data[mid]){
                return mid;
            }
            if(element > data[mid]){
                start = mid + 1;
            }
            else {
                end = mid - 1;
            }
        }
        return -1;
    }
}
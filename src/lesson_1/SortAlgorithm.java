package lesson_1;

public class SortAlgorithm {
    public static void main(String[] args) {
        int [] data = {4,57,365,9,8,47,38,249,7,2,68,79};
        sort(data);
        for (int i : data){
            System.out.println(i);
        }
    }
    public static void sort(int[] data){
        for (int i = 0; i < data.length; i++) {
            int min = data[i];
            for (int j = i+1; j < data.length; j++) {
                if (data[j] < min){
                    min = data[j];
                    data[j] = data[i];
                    data[i] = min;
                }
            }
        }
    }
}
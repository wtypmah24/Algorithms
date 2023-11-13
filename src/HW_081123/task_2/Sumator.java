package HW_081123.task_2;

public class Sumator {
    public static void main(String[] args) {
        System.out.println(getSumLoop(100, 17));
        System.out.println(getSumRecursion(100, 17));
        System.out.println(getSum(100, 17));
    }

    public static int getSumLoop(int limit, int key) {
        int sum = 0;
        for (int i = key; i <= limit; i += key) {
            sum += i;
        }
        return sum;
    }

    //Рекурсия грубой силы
    public static int getSumRecursion(int limit, int key) {
        if (limit == 1) return 0;
        int sum = getSumRecursion(limit - 1, key);
        if (limit % key == 0) sum += limit;
        return sum;
    }

    public static int getSum(int limit, int key){
        int sum = key;
        if (key >= limit) {
            return sum;
        } else {
            sum += getSum(limit, key + key);
        }
        return sum;
    }
}

package lesson_1;

public class GreatestCommonDivision {
    public static void main(String[] args) {
        int result = Evklid(24, 36);
        System.out.println(result);
    }

    //Brute force
    public static int gcbBruteForce(int a, int b) {
        int x = Math.min(a, b);
        int y = Math.max(a, b);

        for (int i = x; i > 1; i--) {
            if (x % i == 0 && y % i == 0) {
                return i;
            }
        }
        return 1;
    }
    //Evklid method
    public static int Evklid (int a, int b){
        int x = Math.min(a, b);
        int y = Math.max(a, b);
        int result = x;
        while (y % x != 0){
            result = y % x;
            y = x;
            x = result;
        }
        return result;
    }
}
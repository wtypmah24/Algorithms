package lesson_4_recursion.task_1;

public class Tabulation {
    /*
    * Решить задачи через рекурсию, и далее оптимизовать алгоритм одним из методов динамического программирования:

    1. Вычислить n-й член последовательности, заданной формулами:
    a(2n) = a(n) + a(n-1),
    a(2n+1) = a(n) — a(n-1),
    a(0) = a(1) = 1.

    1 1 2 0 3 1

    n = 0  ---> 1 1
    n = 1 a(2) = a(1) + a(0) = 1 + 1 = 2
	  a(3) = a(1) - a(0) = 1 - 1 = 0
    n = 2 a(4) = a(2) + a(1) = 2 + 1 = 3
	  a(5) = a(2) - a(1) = 2 - 1 = 1
	  *
    sequence(m) = ?*/

    public static int calculateNthTerm(int n) {
        if (n == 0 || n == 1) {
            return 1;
        }
        int[] cache = new int[n + 1];
        cache[0] = 1;
        cache[1] = 1;
        return calculateNthTerm(n, cache);
    }
    public static int calculateNthTerm(int n, int[] cache) {
        if (n == 0 || n == 1) {
            return 1;
        }
        if (cache[n] != 0) return cache[n];
        if (n % 2 == 0) {
            // a(2n) = a(n) + a(n-1)
            cache[n] = calculateNthTerm(n / 2, cache) + calculateNthTerm(n / 2 - 1, cache);
        } else {
            // a(2n+1) = a(n) — a(n-1)
            cache[n] = calculateNthTerm(n / 2, cache) - calculateNthTerm(n / 2 - 1, cache);
        }
        return cache[n];
    }

    public static void main(String[] args) {
        System.out.println(calculateNthTerm(1));
        System.out.println(calculateNthTerm(2));
        System.out.println(calculateNthTerm(3));
        System.out.println(calculateNthTerm(4));
        System.out.println(calculateNthTerm(5));
        System.out.println(calculateNthTerm(6));
        System.out.println(calculateNthTerm(7));
        System.out.println(calculateNthTerm(8));
        System.out.println(calculateNthTerm(9));
        System.out.println(calculateNthTerm(10));
        System.out.println(calculateNthTerm(11));
    }
}
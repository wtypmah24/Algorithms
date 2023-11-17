package HW_151123;

public class MinCost {
    public static void main(String[] args) {
        int[][] costs = {
                {0, 1, 4, 4, 6},
                {4, 1, 1, 1, 6},
                {4, 4, 4, 1, 6},
                {4, 4, 4, 1, 0}
        };
        System.out.println(getMinCost(costs));
        System.out.println(min2(costs));
    }
    private static int getMinCost(int[][] costs){
        int N = costs.length;
        int M = costs[0].length;
        int[][] dp = new int[N][M]; // Динамическое программирование

        // Заполнение первой строки и первого столбца
        dp[0][0] = costs[0][0];
        for (int j = 1; j < M; j++) {
            dp[0][j] = dp[0][j-1] + costs[0][j];
        }
        for (int i = 1; i < N; i++) {
            dp[i][0] = dp[i-1][0] + costs[i][0];
        }

        // Заполнение оставшихся элементов массива dp
        for (int i = 1; i < N; i++) {
            for (int j = 1; j < M; j++) {
                dp[i][j] = costs[i][j] + Math.min(dp[i-1][j], dp[i][j-1]);
            }
        }

        // Возвращение минимальной стоимости пути до правого нижнего угла
        return dp[N-1][M-1];
    }
    public static int min2(int[][] costs){
        int N = costs.length;
        int M = costs[0].length;
        int minCost = costs[0][0];

        int i = 0;
        int j = 0;

        while (i < N-1 || j < M-1) {
            if (i < N-1 && (j == M-1 || costs[i+1][j] < costs[i][j+1])) {
                minCost = minCost + costs[i+1][j];
                i++;
            } else {
                minCost = minCost + costs[i][j+1];
                j++;
            }
        }
        return minCost;
    }
}

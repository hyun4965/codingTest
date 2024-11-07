package middle2;

public class A6_60 {
    public static int knapsack(int[] weights, int[] values, int capacity) {
        int n = weights.length;
        int[][] dp = new int[n + 1][capacity + 1];

        // Initialize base cases
        for (int i = 0; i <= n; i++) {
            dp[i][0] = 0;
        }
        for (int j = 0; j <= capacity; j++) {
            dp[0][j] = 0;
        }

        // Fill the dp table
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= capacity; j++) {
                if (weights[i - 1] > j) {
                    // 현재 물건의 무게가 현재 용량 j보다 크면, 그 물건을 담을 수 없으므로 이전
                    dp[i][j] = dp[i - 1][j];
                } else {
                    // 딤을수 있는 경우와 담지 못하는 경우 비교
                    dp[i][j] = Math.max(dp[i - 1][j],
                                        dp[i - 1][j - weights[i - 1]] + values[i - 1]);
                }
            }
        }

        // The answer is in dp[n][capacity]
        return dp[n][capacity];
    }

    public static void main(String[] args) {
        int[] weights = {3, 1, 2, 4}; // 각 물건의 무게
        int[] values = {25, 15, 20, 30};  // 각 물건의 가치
        int capacity = 7;             // 배낭의 최대 용량

        int maxValue = knapsack(weights, values, capacity);
        System.out.println("배낭에 넣을 수 있는 최대 가치: " + maxValue);
    }
}

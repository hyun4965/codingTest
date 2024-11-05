package gold;

import java.util.Scanner;

public class BJ12865 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int K = sc.nextInt();

        int[] weight = new int[N + 1]; // 물건의 무게 배열
        int[] value = new int[N + 1];  // 물건의 가치 배열
        int[][] dp = new int[N + 1][K + 1];

        for (int i = 1; i <= N; i++) {
            weight[i] = sc.nextInt();
            value[i] = sc.nextInt();
        }

        // DP 알고리즘
        for (int i = 1; i <= N; i++) {
            for (int w = 1; w <= K; w++) {
                if (weight[i] <= w) {
                    dp[i][w] = Math.max(dp[i - 1][w], dp[i - 1][w - weight[i]] + value[i]);
                } else {
                    dp[i][w] = dp[i - 1][w];
                }
            }
        }

        System.out.println(dp[N][K]);
    }
}
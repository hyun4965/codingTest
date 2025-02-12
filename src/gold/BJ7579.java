package gold;

import java.util.Scanner;

public class BJ7579 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int M = sc.nextInt();

        int[] memory = new int[N];
        int[] cost = new int[N];
        int maxCost = 0;

        for (int i = 0; i < N; i++) {
            memory[i] = sc.nextInt();
        }
        for (int i = 0; i < N; i++) {
            cost[i] = sc.nextInt();
            maxCost += cost[i];
        }
        int[] dp = new int[maxCost + 1];


        for (int i = 0; i < N; i++) {
            for (int j = maxCost; j >= cost[i]; j--) {
                dp[j] = Math.max(dp[j], dp[j - cost[i]] + memory[i]);
            }
        }

        // 최소 비용 탐색
        for (int c = 0; c <= maxCost; c++) {
            if (dp[c] >= M) {
                System.out.println(c);
                return;
            }
        }
    }
}

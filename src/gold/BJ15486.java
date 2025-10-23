package gold;

import java.util.Scanner;

public class BJ15486 {
    // 오늘부터 N+1일째 되는 날 퇴사 -> N일까지 상담 가능
    // Ti: 상담에 걸리는 기간, Pi: 상담 시 얻는 이익
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        int[] T = new int[n];
        int[] P = new int[n];
        for (int i = 0; i < n; i++) {
            T[i] = sc.nextInt();
            P[i] = sc.nextInt();
        }

        int[] dp = new int[n + 1];

        for (int i = 0; i < n; i++) {
            if (i > 0 && dp[i] < dp[i - 1]) {
                dp[i] = dp[i - 1];
            }

            int next = i + T[i];
            if (next <= n) {
                if (dp[next] < dp[i] + P[i]) {
                    dp[next] = dp[i] + P[i];
                }
            }
        }

        if (dp[n] < dp[n - 1]) {
            dp[n] = dp[n - 1];
        }

        System.out.println(dp[n]);
    }
}
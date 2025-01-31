package gold;

import java.util.Scanner;

public class BJ11049 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int[] row = new int[N + 1];
        int[] col = new int[N + 1];
        int[][] dp = new int[N + 1][N + 1];

        for (int i = 1; i <= N; i++) {
            row[i] = sc.nextInt();
            col[i] = sc.nextInt();
        }

        // DP 수행 (길이 2부터 N까지)
        for (int len = 2; len <= N; len++) {
            for (int i = 1; i <= N - len + 1; i++) { // 시작점
                int j = i + len - 1; // 끝점
                dp[i][j] = Integer.MAX_VALUE;

                // 중간 지점 k를 기준으로 나누어 최소 비용을 찾음
                for (int k = i; k < j; k++) {
                    int cost = dp[i][k] + dp[k + 1][j] + row[i] * col[k] * col[j];
                    dp[i][j] = Math.min(dp[i][j], cost);
                }
            }
        }

        System.out.println(dp[1][N]);
    }
}

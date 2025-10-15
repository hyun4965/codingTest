package gold;

import java.util.Scanner;

public class BJ17404 {
    // R, G, B 중 하나 색칠
    public static void main(String[] args) {
        int INF = 1_000_000;
        int result = INF;
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt(); //집의 수

        int[][] houses = new int[N+1][3];
        int[][] dp = new int[N+1][3];
        for (int i = 1; i <= N; i++) {
            for(int j =0; j < 3; j++) {
                houses[i][j] = sc.nextInt();
            }
        }

        for (int k = 0; k < 3; k++) {
            // 첫 번째 집 색 초기화 (선택한 색만 비용, 나머지는 INF)
            for (int i = 0; i < 3; i++) {
                if (i == k) {
                    dp[1][i] = houses[1][i];
                } else {
                    dp[1][i] = INF;
                }
            }


            for (int i = 2; i <= N; i++) {
                dp[i][0] = Math.min(dp[i - 1][1], dp[i - 1][2]) + houses[i][0];
                dp[i][1] = Math.min(dp[i - 1][0], dp[i - 1][2]) + houses[i][1];
                dp[i][2] = Math.min(dp[i - 1][0], dp[i - 1][1]) + houses[i][2];
            }

            for (int i = 0; i < 3; i++) {
                if (i != k) {
                    result = Math.min(result, dp[N][i]);
                }
            }
        }
        System.out.println(result);
    }
}
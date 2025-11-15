package silver;

import java.util.Scanner;

public class BJ11048 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt(); // 행
        int m = sc.nextInt(); // 열

        int[][] miro = new int[n + 1][m + 1];
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= m; j++) {
                miro[i][j] = sc.nextInt();
            }
        }

        int[][] dp = new int[n + 1][m + 1];
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= m; j++) {
                dp[i][j] = miro[i][j] + Math.max(
                        dp[i - 1][j],
                        Math.max(dp[i][j - 1], dp[i - 1][j - 1])
                );
            }
        }

        System.out.println(dp[n][m]);
    }
}
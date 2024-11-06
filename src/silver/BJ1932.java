package silver;

import java.util.Scanner;

public class BJ1932 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        // 삼각형 배열 초기화
        int[][] triangle = new int[n][n];
        int[][] dp = new int[n][n];

        // 삼각형 값 입력받기
        for (int i = 0; i < n; i++) {
            for (int j = 0; j <= i; j++) {
                triangle[i][j] = sc.nextInt();
            }
        }

        // dp 초기화
        dp[0][0] = triangle[0][0];

        // 동적 계획법 계산
        for (int i = 1; i < n; i++) {
            for (int j = 0; j <= i; j++) {
                if (j == 0) {
                    dp[i][j] = dp[i - 1][j] + triangle[i][j];
                } else if (j == i) {
                    dp[i][j] = dp[i - 1][j - 1] + triangle[i][j];
                } else {
                    dp[i][j] = Math.max(dp[i - 1][j - 1], dp[i - 1][j]) + triangle[i][j];
                }
            }
        }

        // 마지막 층에서 최대값 찾기
        int maxSum = 0;
        for (int j = 0; j < n; j++) {
            maxSum = Math.max(maxSum, dp[n - 1][j]);
        }

        System.out.println(maxSum);
    }
}

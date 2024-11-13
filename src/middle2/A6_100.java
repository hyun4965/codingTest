package middle2;

import java.util.Scanner;

public class A6_100 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // 입력 크기
        int n = sc.nextInt();

        // grid와 dp 배열 선언
        int[][] grid = new int[n][n];
        int[][] dp = new int[n][n];

        // grid 배열 값 입력
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                grid[i][j] = sc.nextInt();
            }
        }

        // dp 배열 초기화: 시작점
        dp[0][0] = grid[0][0];

        // 첫 번째 행 초기화 (오른쪽으로만 이동)
        for (int j = 1; j < n; j++) {
            dp[0][j] = dp[0][j - 1] + grid[0][j];
        }

        // 첫 번째 열 초기화 (아래쪽으로만 이동)
        for (int i = 1; i < n; i++) {
            dp[i][0] = dp[i - 1][0] + grid[i][0];
        }

        // 나머지 dp 배열 채우기
        for (int i = 1; i < n; i++) {
            for (int j = 1; j < n; j++) {
                dp[i][j] = Math.min(dp[i - 1][j], dp[i][j - 1]) + grid[i][j];
            }
        }

        System.out.println(dp[n - 1][n - 1]);
    }
}

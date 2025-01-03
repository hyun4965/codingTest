package silver;

import java.util.Scanner;

public class BJ9465 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt(); // 테스트 케이스의 개수
        int[] sum = new int[T];

        for (int t = 0; t < T; t++) {
            int n = sc.nextInt();
            int[][] stickers = new int[2][n]; // 스티커 점수를 저장할 2차원 배열
            int[][] dp = new int[2][n];

            // 첫 번째 줄의 점수 입력
            for (int j = 0; j < n; j++) {
                stickers[0][j] = sc.nextInt();
            }

            // 두 번째 줄의 점수 입력
            for (int j = 0; j < n; j++) {
                stickers[1][j] = sc.nextInt();
            }
            dp[0][0] = stickers[0][0];
            dp[1][0] = stickers[1][0];

            if(n>1){
                dp[0][1] = stickers[0][1] + dp[1][0];
                dp[1][1] = stickers[1][1] + dp[0][0];
            }

            //상하좌우 합...
            for (int m = 2; m < n; m++) {
                dp[0][m] = stickers[0][m] + Math.max(dp[1][m - 1], dp[1][m - 2]);
                dp[1][m] = stickers[1][m] + Math.max(dp[0][m - 1], dp[0][m - 2]);
            }
            System.out.println(Math.max(dp[0][n - 1], dp[1][n - 1]));
        }
        sc.close();
    }
}

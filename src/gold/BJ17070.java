package gold;

import java.util.*;

public class BJ17070 {
    static int N;
    static int[][] house;
    static int[][][] dp;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        house = new int[N][N];
        dp = new int[N][N][3];

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                house[i][j] = sc.nextInt();
            }
        }

        System.out.println(find());
    }

    static int find() {
        dp[0][1][0] = 1; // 초기 파이프 상태 (가로 방향)

        for (int i = 0; i < N; i++) {
            for (int j = 1; j < N; j++) {
                if (house[i][j] == 1) {
                    continue; // 벽이면 진행 불가
                }

                // 가로(0) 방향 이동
                if (j > 0) {
                    dp[i][j][0] += dp[i][j - 1][0] + dp[i][j - 1][1];
                }

                // 세로(2) 방향 이동
                if (i > 0) {
                    dp[i][j][2] += dp[i - 1][j][2] + dp[i - 1][j][1];
                }

                // 대각선(1) 이동 (3칸 모두 빈칸이어야 함)
                if (i > 0 && j > 0 && house[i - 1][j] == 0 && house[i][j - 1] == 0) {
                    dp[i][j][1] += dp[i - 1][j - 1][0] + dp[i - 1][j - 1][1] + dp[i - 1][j - 1][2];
                }
            }
        }

        return dp[N - 1][N - 1][0] + dp[N - 1][N - 1][1] + dp[N - 1][N - 1][2];
    }
}
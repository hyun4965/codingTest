package gold;

import java.util.Scanner;

public class BJ1520 {
    static int M, N;
    static int[][] map, dp;
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        M = sc.nextInt();
        N = sc.nextInt();
        map = new int[M][N];
        dp = new int[M][N];

        for (int i = 0; i < M; i++) {
            for (int j = 0; j < N; j++) {
                map[i][j] = sc.nextInt();
                dp[i][j] = -1;
            }
        }

        System.out.println(dfs(0, 0));
    }

    static int dfs(int x, int y) {
        // 도착 지점 도달 시 경로 1개 반환
        if (x == M - 1 && y == N - 1) {
            return 1;
        }

        // 이미 방문한 경우 저장된 값
        if (dp[x][y] != -1) {
            return dp[x][y];
        }

        dp[x][y] = 0;
        for (int i = 0; i < 4; i++) {
            int nx = x + dx[i];
            int ny = y + dy[i];

            if (nx >= 0 && nx < M && ny >= 0 && ny < N && map[nx][ny] < map[x][y]) {
                dp[x][y] += dfs(nx, ny);
            }
        }

        return dp[x][y];
    }
}

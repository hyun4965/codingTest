package gold;

import java.util.*;

public class BJ2638 {
    static int[] dx = {0, 1, 0, -1};
    static int[] dy = {1, 0, -1, 0};
    static int[][] board;
    static boolean[][] visited;
    static int N, M;
    static int cheese;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        M = sc.nextInt();
        board = new int[N][M];
        cheese = 0;

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                board[i][j] = sc.nextInt();
                //치즈 존재.
                if (board[i][j] == 1) {
                    cheese++;
                }
            }
        }

        int time = 0;
        while (cheese > 0) {
            time++;
            bfsAndMelt();
        }

        System.out.println(time);
    }

    public static void bfsAndMelt() {
        visited = new boolean[N][M];
        int[][] airTouch = new int[N][M];

        Queue<int[]> q = new LinkedList<>();
        q.offer(new int[]{0, 0});
        //모서리는 없다 했으므로 0 시작
        visited[0][0] = true;

        while (!q.isEmpty()) {
            int[] cur = q.poll();
            for (int i = 0; i < 4; i++) {
                int nx = cur[0] + dx[i];
                int ny = cur[1] + dy[i];
                if (nx < 0 || ny < 0 || nx >= N || ny >= M) {
                    continue;
                }
                if (visited[nx][ny]) {
                    continue;
                }

                if (board[nx][ny] == 0) {
                    visited[nx][ny] = true;
                    q.offer(new int[]{nx, ny});
                }
                else if (board[nx][ny] == 1) {
                    airTouch[nx][ny]++;
                }
            }
        }

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (board[i][j] == 1 && airTouch[i][j] >= 2) {
                    board[i][j] = 0;
                    cheese--;
                }
            }
        }
    }
}

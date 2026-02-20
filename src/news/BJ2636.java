package news;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class BJ2636 {

    static boolean[][] visited;
    static int[][] square;

    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};

    static int lastCount = 0;
    static int time = 0;

    static int n, m;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt(); // 세로
        m = sc.nextInt(); // 가로

        square = new int[n][m];

        for (int y = 0; y < n; y++) {
            for (int x = 0; x < m; x++) {
                square[y][x] = sc.nextInt();
            }
        }

        while (true) {
            int cheeseCount = 0;
            for (int y = 0; y < n; y++) {
                for (int x = 0; x < m; x++) {
                    if (square[y][x] == 1) cheeseCount++;
                }
            }

            if (cheeseCount == 0) {
                System.out.println(time);
                System.out.println(lastCount);
                break;
            }

            lastCount = cheeseCount;
            time++;

            visited = new boolean[n][m];

            findOutsideAir();

            // 바깥 공기와 닿은 치즈 찾기
            for (int y = 0; y < n; y++) {
                for (int x = 0; x < m; x++) {
                    if (square[y][x] == 1) {
                        for (int k = 0; k < 4; k++) {
                            int nx = x + dx[k];
                            int ny = y + dy[k];

                            if (nx < 0 || nx >= m || ny < 0 || ny >= n) continue;

                            if (square[ny][nx] == -1) {
                                square[y][x] = 2;
                                break;
                            }
                        }
                    }
                }
            }

            for (int y = 0; y < n; y++) {
                for (int x = 0; x < m; x++) {
                    if (square[y][x] == -1 || square[y][x] == 2) {
                        square[y][x] = 0;
                    }
                }
            }
        }
    }

    static void findOutsideAir() {
        Queue<int[]> queue = new LinkedList<>();

        visited[0][0] = true;
        square[0][0] = -1;
        queue.offer(new int[]{0, 0});

        while (!queue.isEmpty()) {
            int[] cur = queue.poll();
            int cx = cur[0];
            int cy = cur[1];

            for (int i = 0; i < 4; i++) {
                int nx = cx + dx[i];
                int ny = cy + dy[i];

                if (nx < 0 || nx >= m || ny < 0 || ny >= n) continue;
                if (visited[ny][nx]) continue;

                if (square[ny][nx] != 1) {
                    visited[ny][nx] = true;
                    square[ny][nx] = -1;
                    queue.offer(new int[]{nx, ny});
                }
            }
        }
    }
}

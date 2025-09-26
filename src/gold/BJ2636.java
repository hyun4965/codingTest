package gold;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class BJ2636 {

    static final int[] dx = {-1, 1, 0, 0};
    static final int[] dy = {0, 0, -1, 1};
    static boolean[][] visited;
    static int[][] square;
    static int n, m;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt(); //세로
        m = sc.nextInt(); //가로
        visited = new boolean[n][m];
        square = new int[n][m];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                square[i][j] = sc.nextInt();
            }
        }

        int time = 0; //시간
        int lastCheeseCount = 0; //이전 치즈 카운트

        while (true) {
            int cheeseCount = 0;
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < m; j++) {
                    if (square[i][j] == 1) {
                        cheeseCount++;
                    }
                }
            }

            if (cheeseCount == 0) {
                System.out.println(time);
                System.out.println(lastCheeseCount);
                break;
            }

            lastCheeseCount = cheeseCount;
            time++;
            
            bfs();

            for (int i = 0; i < n; i++) {
                for (int j = 0; j < m; j++) {
                    if (square[i][j] == 1) {
                        for (int k = 0; k < 4; k++) {
                            int ny = i + dy[k];
                            int nx = j + dx[k];

                            if (square[ny][nx] == -1) {
                                square[i][j] = 2;
                                break;
                            }
                        }
                    }
                }
            }

            for (int i = 0; i < n; i++) {
                for (int j = 0; j < m; j++) {
                    if (square[i][j] == 2 || square[i][j] == -1) {
                        square[i][j] = 0;
                    }
                }
            }
        }
    }

    static void bfs() {
        Queue<int[]> q = new LinkedList<>();
        visited = new boolean[n][m];

        q.offer(new int[]{0, 0});
        visited[0][0] = true;
        square[0][0] = -1;

        while (!q.isEmpty()) {
            int[] current = q.poll();
            int y = current[0];
            int x = current[1];

            for (int i = 0; i < 4; i++) {
                int ny = y + dy[i];
                int nx = x + dx[i];

                if (ny >= 0 && ny < n && nx >= 0 && nx < m && !visited[ny][nx] && square[ny][nx] != 1) {
                    visited[ny][nx] = true;
                    square[ny][nx] = -1;
                    q.offer(new int[]{ny, nx});
                }
            }
        }
    }
}

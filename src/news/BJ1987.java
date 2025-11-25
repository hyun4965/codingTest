package news;

import java.util.Scanner;

public class BJ1987 {
    static int R, C;
    static int[][] map;
    static boolean[] visited = new boolean[26];
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};
    static int maxCount = 0;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        R = sc.nextInt();
        C = sc.nextInt();

        map = new int[R][C];

        for (int i = 0; i < R; i++) {
            String str = sc.next();
            for (int j = 0; j < C; j++) {
                map[i][j] = str.charAt(j) - 'A';
            }
        }

        dfs(0, 0, 1);

        System.out.println(maxCount);
    }

    static void dfs(int x, int y, int count) {
        visited[map[x][y]] = true;

        maxCount = Math.max(maxCount, count);

        for (int i = 0; i < 4; i++) {
            int nx = x + dx[i];
            int ny = y + dy[i];

            if (nx >= 0 && ny >= 0 && nx < R && ny < C) {
                if (!visited[map[nx][ny]]) {
                    dfs(nx, ny, count + 1);
                }
            }
        }

        visited[map[x][y]] = false;
    }
}
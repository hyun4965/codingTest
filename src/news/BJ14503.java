package news;

import java.util.Scanner;

public class BJ14503 {
    static int n, m, count;
    static int[][] area;
    static int[] dr = {-1, 0, 1, 0};
    static int[] dc = {0, 1, 0, -1};

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        n = sc.nextInt();
        m = sc.nextInt();
        area = new int[n][m];

        int r = sc.nextInt();
        int c = sc.nextInt();
        int d = sc.nextInt();

        for(int i = 0; i < n; i++) {
            for(int j = 0; j < m; j++) {
                area[i][j] = sc.nextInt();
            }
        }

        count = 1;
        dfs(r, c, d);
        System.out.println(count);
    }

    public static void dfs(int r, int c, int d) {
        area[r][c] = -1;

        for(int i = 0; i < 4; i++) {
            d = (d + 3) % 4;

            int nr = r + dr[d];
            int nc = c + dc[d];

            if(nr >= 0 && nc >= 0 && nr < n && nc < m) {
                if(area[nr][nc] == 0) {
                    count++;
                    dfs(nr, nc, d);

                    return;
                }
            }
        }

        int back = (d + 2) % 4;
        int bx = r + dr[back];
        int by = c + dc[back];

        if(bx >= 0 && by >= 0 && bx < n && by < m && area[bx][by] != 1) {
            dfs(bx, by, d);
        }
    }
}
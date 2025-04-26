package gold;

import java.util.Scanner;

public class BJ14503 {
    static int[][] room;
    static int N, M, r, c, d;
    static int[] dx = {-1, 0, 1, 0};
    static int[] dy = {0, 1, 0, -1};
    static int count = 1;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        M = sc.nextInt();
        r = sc.nextInt();
        c = sc.nextInt();
        d = sc.nextInt();
        room = new int[N][M];
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                room[i][j] = sc.nextInt();
            }
        }
        clean(r, c, d);
        System.out.println(count);
    }

    public static void clean(int x, int y, int d) {
        room[x][y] = -1;
        for (int i = 0; i < 4; i++) {
            d = (d + 3) % 4;
            int nx = x + dx[d];
            int ny = y + dy[d];
            if (nx >= 0 && ny >= 0 && nx < N && ny < M) {
                if (room[nx][ny] == 0) {
                    count++;
                    clean(nx, ny, d);
                    return;
                }
            }
        }

        // 주변에 청소할 곳 없으면 후진
        int backDir = (d + 2) % 4;
        int bx = x + dx[backDir];
        int by = y + dy[backDir];
        if (bx >= 0 && by >= 0 && bx < N && by < M && room[bx][by] != 1) {
            clean(bx, by, d);
        }

    }
}

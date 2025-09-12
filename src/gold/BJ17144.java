package gold;

import java.util.*;

public class BJ17144 {
    static int R, C, T;
    static int[][] a;
    static int up = -1, down = -1;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        R = sc.nextInt();
        C = sc.nextInt();
        T = sc.nextInt();

        a = new int[R][C];

        for (int i = 0; i < R; i++) {
            for (int j = 0; j < C; j++) {
                a[i][j] = sc.nextInt();

                if (a[i][j] == -1) {
                    if (up == -1) {
                        up = i;
                    }
                    else {
                        down = i;
                    }
                }
            }
        }

        while (T>0) {
            diffuse();
            operate();
            T--;
        }

        System.out.println(sumDust());
    }

    static void diffuse() {
        int[][] add = new int[R][C];
        int[] dx = {-1, 1, 0, 0};
        int[] dy = {0, 0, -1, 1};

        for (int x = 0; x < R; x++) {
            for (int y = 0; y < C; y++) {
                if (a[x][y] <= 0) {
                    continue;
                }
                int spread = a[x][y] / 5;
                if (spread == 0) {
                    continue;
                }

                int cnt = 0;
                for (int d = 0; d < 4; d++) {
                    int nx = x + dx[d], ny = y + dy[d];
                    if (nx < 0 || nx >= R || ny < 0 || ny >= C) {
                        continue;
                    }
                    if (a[nx][ny] == -1) {
                        continue;
                    }
                    add[nx][ny] += spread;
                    cnt++;
                }
                a[x][y] -= spread * cnt;
            }
        }

        for (int i = 0; i < R; i++) {
            for (int j = 0; j < C; j++) {
                if (a[i][j] == -1) continue;
                a[i][j] += add[i][j];
            }
        }
    }

    static void operate() {
        for (int i = up - 1; i > 0; i--) {
            a[i][0] = a[i - 1][0];
        }
        for (int j = 0; j < C - 1; j++){
            a[0][j] = a[0][j + 1];
        }
        for (int i = 0; i < up; i++) a[i][C - 1] = a[i + 1][C - 1];
        for (int j = C - 1; j > 1; j--) a[up][j] = a[up][j - 1];
        a[up][1] = 0;

        // 아래쪽 (시계)
        for (int i = down + 1; i < R - 1; i++) a[i][0] = a[i + 1][0];
        for (int j = 0; j < C - 1; j++) a[R - 1][j] = a[R - 1][j + 1];
        for (int i = R - 1; i > down; i--) a[i][C - 1] = a[i - 1][C - 1];
        for (int j = C - 1; j > 1; j--) a[down][j] = a[down][j - 1];
        a[down][1] = 0;

        a[up][0] = -1;
        a[down][0] = -1;
    }

    static int sumDust() {
        int sum = 0;
        for (int i = 0; i < R; i++) {
            for (int j = 0; j < C; j++) {
                if (a[i][j] > 0) sum += a[i][j];
            }
        }
        return sum;
    }
}

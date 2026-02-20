package news;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/*
    공기 청정기 0,0시작
    주변으로 흩어짐 , 막혀있거나 다른것이 있으면 막힌다.
 */

public class BJ17144 {
    static int R, C, T;
    static int[][] map;
    static int up = -1;
    static int down = -1;

    static final int[] dr = {-1, 1, 0, 0};
    static final int[] dc = {0, 0, -1, 1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        R = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());
        T = Integer.parseInt(st.nextToken());

        map = new int[R][C];

        for (int i = 0; i < R; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < C; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
                if (map[i][j] == -1) {
                    if (up == -1) {
                        up = i;
                    } else {
                        down = i;
                    }
                }
            }
        }

        while (T-- > 0) {
            spread();
            operateCleaner();
        }

        System.out.println(sumDust());
    }

    static void spread() {
        int[][] next = new int[R][C];
        next[up][0] = -1;
        next[down][0] = -1;

        for (int r = 0; r < R; r++) {
            for (int c = 0; c < C; c++) {
                if (map[r][c] <= 0) {
                    continue;
                }

                int amount = map[r][c] / 5;
                int count = 0;

                for (int d = 0; d < 4; d++) {
                    int nr = r + dr[d];
                    int nc = c + dc[d];

                    if (nr < 0 || nr >= R || nc < 0 || nc >= C) {
                        continue;
                    }
                    if (map[nr][nc] == -1) {
                        continue;
                    }

                    next[nr][nc] += amount;
                    count++;
                }

                next[r][c] += map[r][c] - (amount * count);
            }
        }

        map = next;
    }

    static void operateCleaner() {
        for (int r = up - 1; r > 0; r--) {
            map[r][0] = map[r - 1][0];
        }
        for (int c = 0; c < C - 1; c++) {
            map[0][c] = map[0][c + 1];
        }
        for (int r = 0; r < up; r++) {
            map[r][C - 1] = map[r + 1][C - 1];
        }
        for (int c = C - 1; c > 1; c--) {
            map[up][c] = map[up][c - 1];
        }
        map[up][1] = 0;

        for (int r = down + 1; r < R - 1; r++) {
            map[r][0] = map[r + 1][0];
        }
        for (int c = 0; c < C - 1; c++) {
            map[R - 1][c] = map[R - 1][c + 1];
        }
        for (int r = R - 1; r > down; r--) {
            map[r][C - 1] = map[r - 1][C - 1];
        }
        for (int c = C - 1; c > 1; c--) {
            map[down][c] = map[down][c - 1];
        }
        map[down][1] = 0;

        map[up][0] = -1;
        map[down][0] = -1;
    }

    static int sumDust() {
        int sum = 0;
        for (int i = 0; i < R; i++) {
            for (int j = 0; j < C; j++) {
                if (map[i][j] > 0) {
                    sum += map[i][j];
                }
            }
        }
        return sum;
    }
}

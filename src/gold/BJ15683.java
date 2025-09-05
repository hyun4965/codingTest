package gold;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class BJ15683 {

    static int N, M;
    static int minBlindSpot = Integer.MAX_VALUE;
    static List<CCTV> cctvList = new ArrayList<>();

    // 방향 배열: 0:상, 1:우, 2:하, 3:좌
    static int[] dr = {-1, 0, 1, 0};
    static int[] dc = {0, 1, 0, -1};

    static int[][][] cctvModes = {
            {}, // 인덱스 0은 사용 안함
            {{1}, {2}, {3}, {0}}, // 1번 CCTV
            {{1, 3}, {0, 2}}, // 2번 CCTV (좌우, 상하)
            {{0, 1}, {1, 2}, {2, 3}, {3, 0}}, // 3번 CCTV (상우, 우하, 하좌, 좌상)
            {{3, 0, 1}, {0, 1, 2}, {1, 2, 3}, {2, 3, 0}}, // 4번 CCTV (세 방향)
            {{0, 1, 2, 3}}  // 5번 CCTV (네 방향)
    };

    static class CCTV {
        int r, c, type;

        CCTV(int r, int c, int type) {
            this.r = r;
            this.c = c;
            this.type = type;
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        M = sc.nextInt();
        int[][] map = new int[N][M];

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                map[i][j] = sc.nextInt();
                if (map[i][j] >= 1 && map[i][j] <= 5) {
                    cctvList.add(new CCTV(i, j, map[i][j]));
                }
            }
        }

        dfs(0, map);

        System.out.println(minBlindSpot);
        sc.close();
    }

    public static void dfs(int cctvIndex, int[][] map) {
        if (cctvIndex == cctvList.size()) {
            int currentBlindSpot = 0;
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < M; j++) {
                    if (map[i][j] == 0) {
                        currentBlindSpot++;
                    }
                }
            }
            minBlindSpot = Math.min(minBlindSpot, currentBlindSpot);
            return;
        }

        CCTV cctv = cctvList.get(cctvIndex);
        int type = cctv.type;
        int r = cctv.r;
        int c = cctv.c;

        for (int[] mode : cctvModes[type]) {
            int[][] copiedMap = copyMap(map);

            for (int dir : mode) {
                watch(copiedMap, r, c, dir);
            }

            dfs(cctvIndex + 1, copiedMap);
        }
    }

    public static void watch(int[][] map, int r, int c, int dir) {
        int nr = r;
        int nc = c;

        while (true) {
            nr += dr[dir];
            nc += dc[dir];

            if (nr < 0 || nr >= N || nc < 0 || nc >= M) {
                break;
            }
            if (map[nr][nc] == 6) {
                break;
            }
            if (map[nr][nc] == 0) {
                map[nr][nc] = -1;
            }
        }
    }

    public static int[][] copyMap(int[][] original) {
        int[][] copy = new int[N][M];
        for (int i = 0; i < N; i++) {
            System.arraycopy(original[i], 0, copy[i], 0, M);
        }
        return copy;
    }
}
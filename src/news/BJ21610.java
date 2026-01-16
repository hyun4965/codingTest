package news;

import java.io.*;
import java.util.*;

public class BJ21610 {
    static int n, m;
    static int[][] map;

    static ArrayList<int[]> clouds;


    static final int[] dr = {0, 0, -1, -1, -1, 0, 1, 1, 1};
    static final int[] dc = {0, -1, -1, 0, 1, 1, 1, 0, -1};

    static final int[] diagR = {-1, -1, 1, 1};
    static final int[] diagC = {-1,  1, -1, 1};

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        map = readMap(br);

        initClouds();

        for (int t = 0; t < m; t++) {
            st = new StringTokenizer(br.readLine());
            int d = Integer.parseInt(st.nextToken());
            int s = Integer.parseInt(st.nextToken());

            moveClouds(d, s);
            rain();
            waterCopyBug();

            boolean[][] wasCloud = markWasCloud();
            makeNewClouds(wasCloud);
        }

        System.out.println(sumWater());
    }


    static int[][] readMap(BufferedReader br) throws Exception {
        int[][] a = new int[n][n];
        StringTokenizer st;
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++) {
                a[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        return a;
    }

    static void initClouds() {
        clouds = new ArrayList<>(4);
        clouds.add(new int[]{n - 1, 0});
        clouds.add(new int[]{n - 1, 1});
        clouds.add(new int[]{n - 2, 0});
        clouds.add(new int[]{n - 2, 1});
    }


    static void moveClouds(int d, int s) {
        s %= n;

        boolean[][] visited = new boolean[n][n];
        ArrayList<int[]> next = new ArrayList<>(clouds.size());

        for (int[] pos : clouds) {
            int r = pos[0], c = pos[1];

            int nr = (r + dr[d] * s) % n;
            int nc = (c + dc[d] * s) % n;
            if (nr < 0) nr += n;
            if (nc < 0) nc += n;

            if (!visited[nr][nc]) {
                visited[nr][nc] = true;
                next.add(new int[]{nr, nc});
            }
        }
        clouds = next;
    }


    static void rain() {
        for (int[] pos : clouds) {
            map[pos[0]][pos[1]]++;
        }
    }


    static void waterCopyBug() {
        for (int[] pos : clouds) {
            int r = pos[0], c = pos[1];
            int add = 0;

            for (int k = 0; k < 4; k++) {
                int nr = r + diagR[k];
                int nc = c + diagC[k];
                if (nr < 0 || nr >= n || nc < 0 || nc >= n) continue;
                if (map[nr][nc] > 0) add++;
            }
            map[r][c] += add;
        }
    }


    static boolean[][] markWasCloud() {
        boolean[][] was = new boolean[n][n];
        for (int[] pos : clouds) {
            was[pos[0]][pos[1]] = true;
        }
        return was;
    }


    static void makeNewClouds(boolean[][] wasCloud) {
        ArrayList<int[]> next = new ArrayList<>();

        for (int r = 0; r < n; r++) {
            for (int c = 0; c < n; c++) {
                if (wasCloud[r][c]) continue;
                if (map[r][c] >= 2) {
                    map[r][c] -= 2;
                    next.add(new int[]{r, c});
                }
            }
        }
        clouds = next;
    }


    static long sumWater() {
        long sum = 0;
        for (int r = 0; r < n; r++) {
            for (int c = 0; c < n; c++) {
                sum += map[r][c];
            }
        }
        return sum;
    }
}

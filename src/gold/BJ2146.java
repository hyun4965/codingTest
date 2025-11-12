package gold;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BJ2146 {
    static int[][] map;
    static boolean[][] visited;
    static int n;
    static int min = Integer.MAX_VALUE;
    static int[] dr = {-1, 1, 0, 0};
    static int[] dc = {0, 0, -1, 1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        map = new int[n][n];
        visited = new boolean[n][n];

        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        int islandId = 2;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (map[i][j] == 1 && !visited[i][j]) {
                    numberIslands(i, j, islandId++);
                }
            }
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (map[i][j] > 1) { // 육지인 경우
                    visited = new boolean[n][n];
                    findShortestBridge(i, j);
                }
            }
        }

        System.out.println(min);
    }

    // 섬에 번호를 매기는 BFS
    private static void numberIslands(int r, int c, int id) {
        Queue<int[]> q = new LinkedList<>();
        q.add(new int[]{r, c});
        visited[r][c] = true;
        map[r][c] = id;

        while (!q.isEmpty()) {
            int[] now = q.poll();
            int curR = now[0];
            int curC = now[1];

            for (int i = 0; i < 4; i++) {
                int nr = curR + dr[i];
                int nc = curC + dc[i];

                if (isValid(nr, nc) && !visited[nr][nc] && map[nr][nc] == 1) {
                    visited[nr][nc] = true;
                    map[nr][nc] = id;
                    q.add(new int[]{nr, nc});
                }
            }
        }
    }

    // 가장 짧은 다리를 찾는 BFS
    private static void findShortestBridge(int r, int c) {
        Queue<int[]> q = new LinkedList<>();
        q.add(new int[]{r, c, 0});
        int currentIslandId = map[r][c];
        visited[r][c] = true;

        while (!q.isEmpty()) {
            int[] now = q.poll();
            int curR = now[0];
            int curC = now[1];
            int dist = now[2];

            if (dist >= min) {
                continue;
            }

            for (int i = 0; i < 4; i++) {
                int nr = curR + dr[i];
                int nc = curC + dc[i];

                if (isValid(nr, nc) && !visited[nr][nc]) {
                    visited[nr][nc] = true;
                    if (map[nr][nc] == 0) {
                        q.add(new int[]{nr, nc, dist + 1});
                    } else if (map[nr][nc] != currentIslandId) {
                        min = Math.min(min, dist);
                        return;
                    }
                }
            }
        }
    }

    private static boolean isValid(int r, int c) {
        return r >= 0 && r < n && c >= 0 && c < n;
    }
}

package news;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BJ2206 {

    static int N, M;
    static int[][] map;

    static int[][][] dist;
    static int[] dr = {-1, 1, 0, 0};
    static int[] dc = {0, 0, -1, 1};

    static class State {
        int r, c, broken;

        public State(int r, int c, int broken) {
            this.r = r;
            this.c = c;
            this.broken = broken;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        map = new int[N][M];
        dist = new int[N][M][2];

        for (int i = 0; i < N; i++) {
            String line = br.readLine();
            for (int j = 0; j < M; j++) {
                map[i][j] = line.charAt(j) - '0';
            }
        }

        System.out.println(bfs());
        br.close();
    }

    static int bfs() {
        Queue<State> q = new LinkedList<>();
        q.add(new State(0, 0, 0));
        dist[0][0][0] = 1;

        while (!q.isEmpty()) {
            State current = q.poll();
            int r = current.r;
            int c = current.c;
            int broken = current.broken;

            if (r == N - 1 && c == M - 1) {
                return dist[r][c][broken];
            }

            for (int i = 0; i < 4; i++) {
                int nr = r + dr[i];
                int nc = c + dc[i];

                if (nr >= 0 && nr < N && nc >= 0 && nc < M) {
                    if (map[nr][nc] == 0 && dist[nr][nc][broken] == 0) {
                        dist[nr][nc][broken] = dist[r][c][broken] + 1;
                        q.add(new State(nr, nc, broken));
                    } else if (map[nr][nc] == 1 && broken == 0) {
                        if (dist[nr][nc][1] == 0) {
                            dist[nr][nc][1] = dist[r][c][0] + 1;
                            q.add(new State(nr, nc, 1));
                        }
                    }
                }
            }
        }

        return -1;
    }
}
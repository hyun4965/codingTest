package gold;

import java.io.*;
import java.util.*;

public class BJ13460 {
    static class Ball {
        int rx, ry, bx, by, depth;
        public Ball(int rx, int ry, int bx, int by, int depth) {
            this.rx = rx;
            this.ry = ry;
            this.bx = bx;
            this.by = by;
            this.depth = depth;
        }
    }

    static int N, M;
    static char[][] board;
    static boolean[][][][] visited;
    static int[] dx = {-1, 1, 0, 0}; // 상 하 좌 우
    static int[] dy = {0, 0, -1, 1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        board = new char[N][M];
        visited = new boolean[N][M][N][M];

        int rx = 0, ry = 0, bx = 0, by = 0;

        for (int i = 0; i < N; i++) {
            String line = br.readLine();
            for (int j = 0; j < M; j++) {
                board[i][j] = line.charAt(j);
                if (board[i][j] == 'R') {
                    rx = i;
                    ry = j;
                    board[i][j] = '.';
                } else if (board[i][j] == 'B') {
                    bx = i;
                    by = j;
                    board[i][j] = '.';
                }
            }
        }

        System.out.println(bfs(rx, ry, bx, by));
    }

    static int bfs(int rx, int ry, int bx, int by) {
        Queue<Ball> q = new LinkedList<>();
        q.offer(new Ball(rx, ry, bx, by, 0));
        visited[rx][ry][bx][by] = true;

        while (!q.isEmpty()) {
            Ball b = q.poll();
            if (b.depth >= 10) return -1;

            for (int d = 0; d < 4; d++) {
                MoveResult red = move(b.rx, b.ry, dx[d], dy[d]);
                MoveResult blue = move(b.bx, b.by, dx[d], dy[d]);

                if (blue.hole) continue; // 파란 구슬 빠지면 실패
                if (red.hole) return b.depth + 1; // 빨간 구슬만 빠졌으면 성공

                // 같은 위치에 있으면 더 많이 움직인 구슬을 뒤로 한 칸 뺌
                if (red.x == blue.x && red.y == blue.y) {
                    if (red.dist > blue.dist) {
                        red.x -= dx[d];
                        red.y -= dy[d];
                    } else {
                        blue.x -= dx[d];
                        blue.y -= dy[d];
                    }
                }

                if (!visited[red.x][red.y][blue.x][blue.y]) {
                    visited[red.x][red.y][blue.x][blue.y] = true;
                    q.offer(new Ball(red.x, red.y, blue.x, blue.y, b.depth + 1));
                }
            }
        }

        return -1;
    }

    static class MoveResult {
        int x, y, dist;
        boolean hole;
        public MoveResult(int x, int y, int dist, boolean hole) {
            this.x = x;
            this.y = y;
            this.dist = dist;
            this.hole = hole;
        }
    }

    static MoveResult move(int x, int y, int dx, int dy) {
        int dist = 0;
        while (true) {
            if (board[x + dx][y + dy] == '#') break;
            x += dx;
            y += dy;
            dist++;
            if (board[x][y] == 'O') return new MoveResult(x, y, dist, true);
        }
        return new MoveResult(x, y, dist, false);
    }
}

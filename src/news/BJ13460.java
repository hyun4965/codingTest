package news;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BJ13460 {

    static int N, M;
    static char[][] board;
    static boolean[][][][] visited;

    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};

    static class State {
        int rx, ry, bx, by, count;

        public State(int rx, int ry, int bx, int by, int count) {
            this.rx = rx;
            this.ry = ry;
            this.bx = bx;
            this.by = by;
            this.count = count;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        board = new char[N][M];
        visited = new boolean[N][M][N][M];

        int rx = 0;
        int ry = 0;
        int bx = 0;
        int by = 0;

        for (int i = 0; i < N; i++) {
            String line = br.readLine();
            for (int j = 0; j < M; j++) {
                board[i][j] = line.charAt(j);

                if (board[i][j] == 'R') {
                    rx = i; ry = j;
                    board[i][j] = '.';
                } else if (board[i][j] == 'B') {
                    bx = i; by = j;
                    board[i][j] = '.';
                }
            }
        }

        System.out.println(bfs(rx, ry, bx, by));
    }

    public static int bfs(int rx, int ry, int bx, int by) {
        Queue<State> q = new LinkedList<>();
        q.offer(new State(rx, ry, bx, by, 0));
        visited[rx][ry][bx][by] = true;

        while (!q.isEmpty()) {
            State cur = q.poll();

            if (cur.count >= 10) {
                return -1;
            }

            for (int i = 0; i < 4; i++) {
                int nbx = cur.bx;
                int nby = cur.by;
                while (board[nbx + dx[i]][nby + dy[i]] != '#') {
                    nbx += dx[i];
                    nby += dy[i];
                    if (board[nbx][nby] == 'O') {
                        break;
                    }
                }

                int nrx = cur.rx;
                int nry = cur.ry;
                while (board[nrx + dx[i]][nry + dy[i]] != '#') {
                    nrx += dx[i];
                    nry += dy[i];
                    if (board[nrx][nry] == 'O') {
                        break;
                    }
                }

                if (board[nbx][nby] == 'O') {
                    continue;
                }

                if (board[nrx][nry] == 'O') {
                    return cur.count + 1;
                }

                if (nrx == nbx && nry == nby) {
                    int distR = Math.abs(nrx - cur.rx) + Math.abs(nry - cur.ry);
                    int distB = Math.abs(nbx - cur.bx) + Math.abs(nby - cur.by);

                    if (distR > distB) {
                        nrx -= dx[i];
                        nry -= dy[i];
                    } else {
                        nbx -= dx[i];
                        nby -= dy[i];
                    }
                }

                if (!visited[nrx][nry][nbx][nby]) {
                    visited[nrx][nry][nbx][nby] = true;
                    q.offer(new State(nrx, nry, nbx, nby, cur.count + 1));
                }
            }
        }

        return -1;
    }
}
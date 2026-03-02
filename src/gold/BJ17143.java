package gold;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BJ17143 {
    static int R, C, M;

    static class Shark {
        int r, c, s, d, z;
        Shark(int r, int c, int s, int d, int z) {
            this.r = r; this.c = c; this.s = s; this.d = d; this.z = z;
        }
    }

    static final int[] dr = {0, -1, 1, 0, 0};
    static final int[] dc = {0, 0, 0, 1, -1};

    static Shark[][] board;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        R = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        board = new Shark[R + 1][C + 1];

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int r = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());
            int s = Integer.parseInt(st.nextToken());
            int d = Integer.parseInt(st.nextToken());
            int z = Integer.parseInt(st.nextToken());

            if (d == 1 || d == 2) {
                int cycle = 2 * (R - 1);
                if (cycle != 0) {
                    s %= cycle;
                }
            } else {
                int cycle = 2 * (C - 1);
                if (cycle != 0) {
                    s %= cycle;
                }
            }

            board[r][c] = new Shark(r, c, s, d, z);
        }

        int answer =0;
        for (int i = 1; i <= C; i++) {
            for (int j = 1; j <= R; j++) {
                if (board[j][i] != null) {
                    answer += board[j][i].z;
                    board[j][i] = null;
                    break;
                }
            }

            Shark[][] next = new Shark[R + 1][C + 1];

            for (int r = 1; r <= R; r++) {
                for (int c = 1; c <= C; c++) {
                    Shark sh = board[r][c];
                    if (sh == null) {
                        continue;
                    }

                    int nr = sh.r;
                    int nc = sh.c;
                    int nd = sh.d;

                    for (int m = 0; m < sh.s; m++) {
                        int tr = nr + dr[nd];
                        int tc = nc + dc[nd];

                        if (tr < 1 || tr > R || tc < 1 || tc > C) {
                            if (nd == 1) {
                                nd = 2;
                            } else if (nd == 2) {
                                nd = 1;
                            } else if (nd == 3) {
                                nd = 4;
                            } else {
                                nd = 3;
                            }

                            tr = nr + dr[nd];
                            tc = nc + dc[nd];
                        }

                        nr = tr;
                        nc = tc;
                    }

                    sh.r = nr;
                    sh.c = nc;
                    sh.d = nd;

                    if (next[nr][nc] == null || next[nr][nc].z < sh.z) {
                        next[nr][nc] = sh;
                    }
                }
            }

            board = next;
        }

        System.out.print(answer);

    }
}

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
    static int N, M;
    static int[][] map;
    static List<CCTV> cctvs = new ArrayList<>();
    static int answer = Integer.MAX_VALUE;

    // 0: 상, 1: 우, 2: 하, 3: 좌
    static int[] dr = {-1, 0, 1, 0};
    static int[] dc = {0, 1, 0, -1};

    static int[][][] directions = {
            {},
            {{0}, {1}, {2}, {3}},
            {{0, 2}, {1, 3}},
            {{0, 1}, {1, 2}, {2, 3}, {3, 0}},
            {{0, 1, 2}, {1, 2, 3}, {2, 3, 0}, {3, 0, 1}},
            {{0, 1, 2, 3}}
    };

    static class CCTV {
        int r, c, type;

        CCTV(int r, int c, int type) {
            this.r = r;
            this.c = c;
            this.type = type;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        map = new int[N][M];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
                if (1 <= map[i][j] && map[i][j] <= 5) {
                    cctvs.add(new CCTV(i, j, map[i][j]));
                }
            }
        }

        dfs(0, map);
        System.out.println(answer);
    }

    static void dfs(int idx, int[][] board) {
        if (idx == cctvs.size()) {
            answer = Math.min(answer, countBlind(board));
            return;
        }

        CCTV cctv = cctvs.get(idx);
        for (int[] option : directions[cctv.type]) {
            int[][] next = copyBoard(board);
            for (int dir : option) {
                watch(next, cctv.r, cctv.c, dir);
            }
            dfs(idx + 1, next);
        }
    }

    static void watch(int[][] board, int r, int c, int dir) {
        int nr = r + dr[dir];
        int nc = c + dc[dir];

        while (inRange(nr, nc) && board[nr][nc] != 6) {
            if (board[nr][nc] == 0) {
                board[nr][nc] = -1;
            }
            nr += dr[dir];
            nc += dc[dir];
        }
    }

    static boolean inRange(int r, int c) {
        return 0 <= r && r < N && 0 <= c && c < M;
    }

    static int countBlind(int[][] board) {
        int count = 0;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (board[i][j] == 0) {
                    count++;
                }
            }
        }
        return count;
    }

    static int[][] copyBoard(int[][] board) {
        int[][] copied = new int[N][M];
        for (int i = 0; i < N; i++) {
            System.arraycopy(board[i], 0, copied[i], 0, M);
        }
        return copied;
    }
}
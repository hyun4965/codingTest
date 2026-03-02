package gold;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BJ15684 {
    static int N, M, H;
    static boolean[][] ladder;
    static int answer = -1;
    static int maxDepth;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        H = Integer.parseInt(st.nextToken());

        ladder = new boolean[H + 1][N + 1];

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            ladder[a][b] = true;
        }

        for (int i = 0; i <= 3; i++) {
            maxDepth = i;
            if (dfs(0, 0)) {
                answer = i;
                break;
            }
        }

        System.out.print(answer);
    }

    private static boolean dfs(int start, int depth) {
        if (depth == maxDepth) {
            return isValid();
        }

        if (isValid()) {
            return true;
        }

        int total = H * (N - 1);
        for (int i = start; i < total; i++) {
            int row = i / (N - 1) + 1;
            int col = i % (N - 1) + 1;

            if (canPlace(row, col)) {
                ladder[row][col] = true;
                if (dfs(i + 1, depth + 1)) {
                    return true;
                }
                ladder[row][col] = false;
            }
        }
        return false;
    }

    private static boolean canPlace(int row, int col) {
        if (ladder[row][col]) {
            return false;
        }
        if (col > 1 && ladder[row][col - 1]) {
            return false;
        }
        return !(col < N - 1 && ladder[row][col + 1]);
    }

    private static boolean isValid() {
        for (int i = 1; i <= N; i++) {
            int col = i;
            for (int j = 1; j <= H; j++) {
                if (col <= N - 1 && ladder[j][col]) {
                    col++;
                } else if (col > 1 && ladder[j][col - 1]) {
                    col--;
                }
            }
            if (col != i) {
                return false;
            }
        }
        return true;
    }
}

import java.util.*;

class Solution {
    public int solution(int[][] board, int[][] skill) {
        int n = board.length;
        int m = board[0].length;

        long[][] diff = new long[n + 1][m + 1];

        for (int[] s : skill) {
            int type = s[0];  // 1: 공격, 2: 회복
            int r1 = s[1], c1 = s[2];
            int r2 = s[3], c2 = s[4];
            int degree = s[5];

            long val = (type == 1) ? -degree : degree;

            diff[r1][c1] += val;
            if (c2 + 1 <= m - 1) diff[r1][c2 + 1] -= val;
            if (r2 + 1 <= n - 1) diff[r2 + 1][c1] -= val;
            if (r2 + 1 <= n - 1 && c2 + 1 <= m - 1) diff[r2 + 1][c2 + 1] += val;
        }

        for (int i = 0; i < n; i++) {
            long run = 0;
            for (int j = 0; j < m; j++) {
                run += diff[i][j];
                diff[i][j] = run;
            }
        }
        for (int j = 0; j < m; j++) {
            long run = 0;
            for (int i = 0; i < n; i++) {
                run += diff[i][j];
                diff[i][j] = run;
            }
        }

        int answer = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                long finalVal = board[i][j] + diff[i][j];
                if (finalVal > 0) answer++;
            }
        }
        return answer;
    }
}

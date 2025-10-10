import java.util.*;

class Solution {
    public boolean solution(int[][] key, int[][] lock) {
        int m = key.length;
        int n = lock.length;

        int off = m - 1;
        int size = n + 2 * off; 
        int[][] board = new int[size][size];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                board[off + i][off + j] = lock[i][j];
            }
        }

        int[][] cur = key;
        for (int r = 0; r < 4; r++) {
            for (int x = 0; x <= size - m; x++) {
                for (int y = 0; y <= size - m; y++) {
                    apply(board, cur, x, y, +1); 
                    if (valid(board, off, n)) return true;
                    apply(board, cur, x, y, -1); 
                }
            }
            cur = rotate90(cur);
        }
        return false;
    }

    private void apply(int[][] board, int[][] key, int x, int y, int val) {
        int m = key.length;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < m; j++) {
                board[x + i][y + j] += key[i][j] * val;
            }
        }
    }

    private boolean valid(int[][] board, int off, int n) {
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (board[off + i][off + j] != 1) return false;
            }
        }
        return true;
    }

    private int[][] rotate90(int[][] a) {
        int m = a.length;
        int[][] b = new int[m][m];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < m; j++) {
                b[j][m - 1 - i] = a[i][j];
            }
        }
        return b;
    }
}

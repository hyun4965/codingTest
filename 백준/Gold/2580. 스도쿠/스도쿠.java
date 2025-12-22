import java.io.*;
import java.util.*;

public class Main {
    static int[][] board = new int[9][9];
    static int[] rowMask = new int[9];
    static int[] colMask = new int[9];
    static int[] boxMask = new int[9];
    static ArrayList<int[]> blanks = new ArrayList<>();
    static boolean solved = false;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        for (int r = 0; r < 9; r++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int c = 0; c < 9; c++) {
                int v = Integer.parseInt(st.nextToken());
                board[r][c] = v;

                if (v == 0) {
                    blanks.add(new int[]{r, c});
                } else {
                    int bit = 1 << v; 
                    rowMask[r] |= bit;
                    colMask[c] |= bit;
                    boxMask[boxIndex(r, c)] |= bit;
                }
            }
        }

        dfs(0);

        StringBuilder sb = new StringBuilder();
        for (int r = 0; r < 9; r++) {
            for (int c = 0; c < 9; c++) {
                sb.append(board[r][c]);
                if (c < 8) sb.append(' ');
            }
            sb.append('\n');
        }
        System.out.print(sb.toString());
    }

    static int boxIndex(int r, int c) {
        return (r / 3) * 3 + (c / 3);
    }

    static void dfs(int idx) {
        if (solved) return;
        if (idx == blanks.size()) {
            solved = true;
            return;
        }

        int r = blanks.get(idx)[0];
        int c = blanks.get(idx)[1];
        int b = boxIndex(r, c);

        int used = rowMask[r] | colMask[c] | boxMask[b];

        for (int num = 1; num <= 9; num++) {
            int bit = 1 << num;
            if ((used & bit) != 0) continue;

            board[r][c] = num;
            rowMask[r] |= bit;
            colMask[c] |= bit;
            boxMask[b] |= bit;

            dfs(idx + 1);
            if (solved) return;

            board[r][c] = 0;
            rowMask[r] ^= bit;
            colMask[c] ^= bit;
            boxMask[b] ^= bit;
        }
    }
}

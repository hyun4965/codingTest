package gold;

import java.util.Scanner;

public class BJ1285 {
    static int N;
    static char[][] board;
    static int min = Integer.MAX_VALUE;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        board = new char[N][N];
        for (int i = 0; i < N; i++) {
            String line = sc.next();
            for (int j = 0; j < N; j++) {
                board[i][j] = line.charAt(j);
            }
        }

        for (int i = 0; i < (1 << N); i++) {
            int totalTails = 0;

            for (int col = 0; col < N; col++) {
                int tails = 0;

                for (int row = 0; row < N; row++) {
                    boolean r = (i & (1 << row)) != 0;
                    char coin = board[row][col];
                    if (r) {
                        coin = reverseCoin(coin);
                    }
                    if (coin == 'T') {
                        tails++;
                    }
                }

                totalTails += Math.min(tails, N - tails);
            }

            min = Math.min(min, totalTails);
        }

        System.out.println(min);
    }

    private static char reverseCoin(char c) {
        if (c == 'H') {
            return 'T';
        } else {
            return 'H';
        }
    }
}

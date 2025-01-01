package gold;

import java.util.Scanner;

public class BJ25682 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int M = sc.nextInt();
        int K = sc.nextInt();
        sc.nextLine();

        char[][] board = new char[N][M];

        for (int i = 0; i < N; i++) {
            String line = sc.nextLine();
            for (int j = 0; j < M; j++) {
                board[i][j] = line.charAt(j);
            }
        }

        int[][] whiteStart = new int[N + 1][M + 1];
        int[][] blackStart = new int[N + 1][M + 1];

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                int whiteColor = ((i + j) % 2 == 0) ? 'W' : 'B';
                int blackColor = ((i + j) % 2 == 0) ? 'B' : 'W';

                whiteStart[i + 1][j + 1] = whiteStart[i][j + 1] + whiteStart[i + 1][j] - whiteStart[i][j] + (board[i][j] == whiteColor ? 0 : 1);
                blackStart[i + 1][j + 1] = blackStart[i][j + 1] + blackStart[i + 1][j] - blackStart[i][j] + (board[i][j] == blackColor ? 0 : 1);
            }
        }

        int minPaint = Integer.MAX_VALUE;
        for (int i = 0; i <= N - K; i++) {
            for (int j = 0; j <= M - K; j++) {
                int whiteCost = whiteStart[i + K][j + K] - whiteStart[i][j + K] - whiteStart[i + K][j] + whiteStart[i][j];
                int blackCost = blackStart[i + K][j + K] - blackStart[i][j + K] - blackStart[i + K][j] + blackStart[i][j];
                minPaint = Math.min(minPaint, Math.min(whiteCost, blackCost));
            }
        }

        System.out.println(minPaint);
    }
}

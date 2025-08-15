package silver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BJ1051 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken()); // 행
        int M = Integer.parseInt(st.nextToken()); // 열

        char[][] board = new char[N][M];
        for (int i = 0; i < N; i++) {
            String line = br.readLine().trim();
            for (int j = 0; j < M; j++) {
                board[i][j] = line.charAt(j);
            }
        }

        int maxSide = 1;

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                int maxK = Math.min(N - 1 - i, M - 1 - j);
                for (int k = 1; k <= maxK; k++) {
                    char c = board[i][j];
                    if (board[i][j + k] == c && board[i + k][j] == c && board[i + k][j + k] == c) {
                        maxSide = Math.max(maxSide, k + 1);
                    }
                }
            }
        }

        int answerArea = maxSide * maxSide;
        System.out.println(answerArea);
    }
}

package gold;

import java.util.Arrays;
import java.util.Scanner;

public class BJ11062 {
    private static int[] cards;
    private static int[][] dp;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();

        while (T-- > 0) {
            int N = sc.nextInt();
            cards = new int[N];
            dp = new int[N][N];

            for (int i = 0; i < N; i++) {
                cards[i] = sc.nextInt();
                Arrays.fill(dp[i], -1);
            }

            int result = cardpick(0, N - 1);
            System.out.println(result);
        }
        sc.close();
    }


    private static int cardpick(int left, int right) {
        //끝
        if (left > right) {
            return 0;
        }

        //이미 계산한 값
        if (dp[left][right] != -1) {
            return dp[left][right];
        }

        //턴 판단
        int turnsPlayed = cards.length - (right - left + 1);
        boolean isMyTurn = (turnsPlayed % 2 == 0);

        if (isMyTurn) {
            int pickLeft = cards[left] + cardpick(left + 1, right);
            int pickRight = cards[right] + cardpick(left, right - 1);
            return dp[left][right] = Math.max(pickLeft, pickRight);
        } else {
            int opponentPicksLeft = cardpick(left + 1, right);
            int opponentPicksRight = cardpick(left, right - 1);
            return dp[left][right] = Math.min(opponentPicksLeft, opponentPicksRight);
        }
    }
}
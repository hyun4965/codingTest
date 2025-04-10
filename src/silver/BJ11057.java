package silver;

import java.util.Scanner;

public class BJ11057 {
    static int MOD = 10007;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int count = 0; //결과
        int[][] dp= new int[N+1][10];

        for (int i = 0; i < 10; i++) {
            dp[1][i] = 1;
        }


        for (int i = 2; i <= N; i++) {
            for (int j = 0; j < 10; j++) {
                for (int k = 0; k <= j; k++) {
                    dp[i][j] = (dp[i][j] + dp[i - 1][k]) % MOD;
                }
            }
        }
        for (int i = 0; i < 10; i++) {
            count = (count + dp[N][i]) % MOD;
        }
        System.out.println(count%MOD);
    }
}

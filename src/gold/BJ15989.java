package gold;

import java.util.Scanner;

public class BJ15989 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        StringBuilder sb = new StringBuilder();
        int[][]dp;

        int T = sc.nextInt();
        dp = new int[10001][4];
        for(int t = 0; t<T; t++) {
            int N = sc.nextInt();
            dp[1][1] = dp[2][1] = dp[2][2] = dp[3][1] = dp[3][2] = dp[3][3] = 1;
            for(int i=4; i<=N; i++)  {
                dp[i][1] = dp[i-1][1];
                dp[i][2] = dp[i-2][1] + dp[i-2][2];
                dp[i][3] = dp[i-3][1] + dp[i-3][2] + dp[i-3][3];
            }
            sb.append(dp[N][3]+dp[N][2]+dp[N][1]+"\n");
        }
        System.out.println(sb.toString());
    }
}

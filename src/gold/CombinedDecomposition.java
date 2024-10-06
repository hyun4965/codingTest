package gold;

import java.util.*;

public class CombinedDecomposition {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int K = sc.nextInt();

        int dp[][] = new int[N+1][K+1];

        for (int i = 0; i <= N; i++) {
            dp[i][0] = 0;
            dp[i][1] = 1;
        }

        for (int j = 1; j <= K; j++) {
            dp[1][j] =j;
        }

        for(int i=2;i<=N;i++){
            for(int j=2;j<=K;j++){
                dp[i][j] = (dp[i-1][j] + dp[i][j-1]) % 1000000000;
            }
        }

        System.out.println(dp[N][K]);
    }
}

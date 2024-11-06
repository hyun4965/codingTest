package silver;

import java.util.Scanner;

public class BJ2156 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] glasses = new int[n+1];
        int[] dp = new int[n+1];

        for (int i = 1; i <= n; i++) {
            glasses[i] = sc.nextInt();
        }
        //n이 1이상일때
        if (n >= 1) {
            dp[1] = glasses[1];
        }
        //n이 2이상일때
        if (n >= 2) {
            dp[2] = glasses[1] + glasses[2];
        }

        for (int i = 3; i <= n; i++) {
            dp[i] = Math.max(dp[i-1], Math.max(dp[i-2] + glasses[i], dp[i-3] + glasses[i-1] + glasses[i]));
        }

        System.out.println(dp[n]);
    }
}

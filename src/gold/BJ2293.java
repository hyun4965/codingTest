package gold;

import java.util.Scanner;

public class BJ2293 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int k = sc.nextInt();
        int[] dp = new int[k + 1];
        int[] coin = new int[n];
        for (int i = 0; i < n; i++) {
            coin[i] = sc.nextInt();
        }
        dp[0] = 1;
        for (int i = 0; i < n; i++){
            for (int j = coin[i]; j <= k; j++){
                dp[j] += dp[j-coin[i]];
            }
        }
        System.out.println(dp[k]);
    }
}

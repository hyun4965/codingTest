package gold;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BJ2133 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        if (n % 2 != 0) {
            System.out.println(0);
            return;
        }

        int size = (n == 0) ? 3 : n + 1;
        int[] dp = new int[size];

        dp[0] = 1;
        dp[2] = 3;

        for (int i = 4; i <= n; i += 2) {
            dp[i] = 4 * dp[i - 2] - dp[i - 4];
        }

        System.out.println(dp[n]);
    }
}
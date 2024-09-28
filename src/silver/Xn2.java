package silver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Xn2 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] dp = new int[n + 1];

        dp[1] = 1;  // 2×1 직사각형을 채우는 방법의 수는 1가지
        if (n > 1) {
            dp[2] = 3;  // 2×2 직사각형을 채우는 방법의 수는 3가지 (1×2 두 개, 2×1 두 개, 2×2 하나)
        }

        for (int i = 3; i <= n; i++) {
            dp[i] = (dp[i-1] + 2 * dp[i-2]) % 10007;
        }

        System.out.println(dp[n]);
    }
}
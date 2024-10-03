package silver;


import java.io.*;

public class Ecs {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        // n이 1인 경우 이친수는 1개 (1)
        if (n == 1) {
            System.out.println(1);
            return;
        }

        long prevZero = 0; // dp[i-1][0]
        long prevOne = 1;  // dp[i-1][1]

        for (int i = 2; i <= n; i++) {
            long currentZero = prevZero + prevOne; // dp[i][0] = dp[i-1][0] + dp[i-1][1]
            long currentOne = prevZero;            // dp[i][1] = dp[i-1][0]

            prevZero = currentZero;
            prevOne = currentOne;
        }

        System.out.println(prevZero + prevOne);
    }
}

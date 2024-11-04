package silver;

import java.util.Scanner;

public class BJ1904 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        System.out.println(countBinarySequences(N));
    }

    public static int countBinarySequences(int n) {
        final int MOD = 15746;

        if (n == 1) {
            return 1;
        } else if (n == 2) {
            return 2;
        }

        int prev2 = 1; // dp[1]
        int prev1 = 2; // dp[2]
        int current = 0;

        for (int i = 3; i <= n; i++) {
            current = (prev1 + prev2) % MOD;
            prev2 = prev1;
            prev1 = current;
        }

        return prev1;
    }
}

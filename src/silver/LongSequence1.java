package silver;

import java.util.Scanner;

//백준 실버 11053
public class LongSequence1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int[]arr = new int[N];
        int[] dp = new int[N];
        for (int i = 0; i < N; i++) {
            arr[i] = sc.nextInt();
        }

        int maxLength = 0;

        for (int i = 0; i < N; i++) {
            dp[i] = 1; // 자기꺼 1개
            for (int j = 0; j < i; j++) {
                if (arr[i] > arr[j]) {
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                }
            }
            maxLength = Math.max(maxLength, dp[i]);
        }

        System.out.println(maxLength);
    }
}

package silver;

import java.util.Scanner;

public class BJ11055 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt(); //수열 A의 크기
        int[] arr = new int[N];
        int[] dp = new int[N];
        for (int i = 0; i < N; i++) {
            arr[i] = sc.nextInt();
            dp[i] = arr[i];
        }

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < i; j++) {
                if (arr[j] < arr[i]) {
                    dp[i] = Math.max(dp[i], dp[j] + arr[i]);
                }
            }
        }
        int maxSum = 0;
        for(int i = 0; i < N; i++){
            maxSum = Math.max(maxSum,dp[i]);
        }
        System.out.println(maxSum);

    }
}

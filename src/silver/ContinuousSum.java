package silver;

import java.util.Scanner;

public class ContinuousSum {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        //N입력받기
        int N=sc.nextInt();

        //arr입력받기
        int[] arr = new int[N];
        int[] dp = new int[N];
        for(int i=0;i<N;i++){
            arr[i]=sc.nextInt();
        }

        dp[0] = arr[0];
        int maxSum = arr[0];

        for (int i = 1; i < N; i++) {
            // dp[i]는 i번째 숫자를 마지막으로 하는 최대 연속 합
            dp[i] = Math.max(arr[i], dp[i - 1] + arr[i]);
            maxSum = Math.max(maxSum, dp[i]);
        }

        System.out.println(maxSum);
    }
}

package silver;

import java.util.Scanner;

public class BJ14501 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int[] T = new int[N+1]; //상담 완료 걸리는 기간
        int[] P = new int[N+1]; //상담 하였을때 받을 수 있는 금액
        int[] dp = new int[N+2];
        dp[0] = 0;
        T[0] = 0;
        P[0] = 0;

        for (int i = 1; i <= N; i++) {
            T[i] = sc.nextInt();
            P[i] = sc.nextInt();
        }
        //dp의 값 저장할 값
        int maxSum = 0;

        for(int i = 1; i <= N; i++){
            dp[i+1] = Math.max(dp[i], dp[i+1]);
            if(i+T[i]<=N+1){ //T + i 가 범위를 벗어나지 않는 경우.
                dp[i+T[i]]=Math.max(dp[i + T[i]], dp[i] + P[i]);//기간 더했을때랑 현재 값이랑 비교
                maxSum = Math.max(maxSum,dp[i+T[i]]);
            }
        }
        System.out.println(maxSum);
    }
}

package silver;

import java.util.Scanner;

public class BJ11722 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt(); //수열의 크기
        int[] arr = new int[N];
        int[] dp = new int[N];
        int maxLen =0;

        for (int i = 0; i < N; i++) {
            arr[i] = sc.nextInt();
            dp[i] = 1;
        }

        for(int i=0; i<N; i++){
            for(int j=0; j<i; j++){
                if(arr[i] < arr[j]){
                    dp[i] = Math.max(dp[i], dp[j]+ 1);
                }
            }
        }

        for(int i=0; i<N; i++){
            maxLen = Math.max(maxLen, dp[i]);
        }
        System.out.println(maxLen);
    }
}

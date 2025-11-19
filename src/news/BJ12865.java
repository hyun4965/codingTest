package news;

import java.util.Scanner;

public class BJ12865 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt(); //물품의 수
        int k = sc.nextInt(); //버틸 수 있는 무게
        int[] w = new int[n]; // 각 물건의 무게
        int[] v = new int[n]; // 각 물건의 가치

        for (int i = 0; i < n; i++) {
            w[i] = sc.nextInt();
            v[i] = sc.nextInt();
        }
        int[] dp = new int[k+1];

        for(int i =0; i<n; i++){
            for(int j=k; j>=w[i]; j--){
                dp[j] = Math.max(dp[j], dp[j-w[i]]+v[i]);
            }
        }
        System.out.println(dp[k]);
    }
}

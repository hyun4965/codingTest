package news;

import java.util.Scanner;

public class BJ11054 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = new int[n];
        int[] r_dp = new int[n];
        int[] l_dp = new int[n];

        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }
        sc.close();
        for(int i = 0; i < n; i++) {
            r_dp[i] = 1;
            for(int j = 0; j < i; j++) {
                if(arr[j] < arr[i] && r_dp[i] < r_dp[j] + 1) {
                    r_dp[i] = r_dp[j] + 1;
                }
            }
        }

        for(int i = n - 1; i >= 0; i--) {
            l_dp[i] = 1;
            for(int j = n - 1; j > i; j--) {
                if(arr[j] < arr[i] && l_dp[i] < l_dp[j] + 1) {
                    l_dp[i] = l_dp[j] + 1;
                }
            }
        }
        int max = 0;
        for(int i = 0; i < n; i++) {
            if(max < r_dp[i] + l_dp[i] - 1) {
                max = r_dp[i] + l_dp[i] - 1;
            }
        }

        System.out.println(max);
    }
}

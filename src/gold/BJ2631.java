package gold;

import java.util.Scanner;

public class BJ2631 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt(); //아이들의 수

        int[] students = new int[n];
        int[] dp = new int[n];

        //학생 순서 입력
        for (int i = 0; i < n; i++) {
            students[i] = sc.nextInt();
        }

        int lis = 0;
        for (int i = 0; i < n; i++) {
            dp[i] = 1;
            for (int j = 0; j < i; j++) {
                if (students[j] < students[i]) {
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                }
            }
            lis = Math.max(lis, dp[i]);
        }
        //증가하는 함수를 전체 갯수에서 뺌
        System.out.println(n - lis);
    }
}

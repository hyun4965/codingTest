package silver;

import java.util.Scanner;

public class BJ1003 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int T = sc.nextInt();

        // 미리 선언
        int[][] dp = new int[41][2];

        // 초기 값 설정
        dp[0][0] = 1; // f(0)일 때 0의 출력 횟수는 1
        dp[0][1] = 0; // f(0)일 때 1의 출력 횟수는 0
        dp[1][0] = 0; // f(1)일 때 0의 출력 횟수는 0
        dp[1][1] = 1; // f(1)일 때 1의 출력 횟수는 1

        // 동적 계획법으로 미리 계산
        for (int i = 2; i <= 40; i++) {
            dp[i][0] = dp[i-1][0] + dp[i-2][0]; // f(i)에서 0의 출력 횟수
            dp[i][1] = dp[i-1][1] + dp[i-2][1]; // f(i)에서 1의 출력 횟수
        }

        for (int t = 0; t < T; t++) {
            int N = sc.nextInt();
            System.out.println(dp[N][0] + " " + dp[N][1]);
        }
    }
}

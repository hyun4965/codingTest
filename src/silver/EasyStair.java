package silver;

import java.io.*;
public class EasyStair {

    static Long[][] dp;
    static int N;
    final static long MOD = 1000000000;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        N = Integer.parseInt(br.readLine());
        dp = new Long[N+1][10]; //테이블 초기화

        //초기조건 길이가 1인 계단수는 1~9 1개씩
        for(int i = 0; i < 10; i++) {
            dp[1][i] = 1L;
        }

        dp[1][0] = 0L; //0시작 X

        // DP 테이블 채우기
        for (int i = 2; i <= N; i++) {
            for (int j = 0; j <= 9; j++) {
                if (j == 0) {
                    dp[i][j] = dp[i - 1][1] % MOD;  // j = 0일 때는 이전 자리수는 1이어야 함
                } else if (j == 9) {
                    dp[i][j] = dp[i - 1][8] % MOD;  // j = 9일 때는 이전 자리수는 8이어야 함
                } else {
                    dp[i][j] = (dp[i - 1][j - 1] + dp[i - 1][j + 1]) % MOD;  // 그 외는 dp[i-1][j-1]과 dp[i-1][j+1]의 합
                }
            }
        }

        // 최종 결과 계산: 길이가 N인 계단 수의 총합을 구함
        long result = 0;
        for (int i = 0; i <= 9; i++) {
            result = (result + dp[N][i]) % MOD;
        }

        System.out.println(result);

    }
}

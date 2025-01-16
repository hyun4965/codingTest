package gold;

import java.util.Scanner;

public class BJ11066 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt(); // 테스트 케이스 개수

        for (int t = 0; t < T; t++) { // 테스트 케이스 순회
            int K = sc.nextInt(); // 파일의 수
            int[] files = new int[K + 1]; //파일 크기 저장
            int[] sum = new int[K + 1]; //파일 크기 누적합
            int[][] dp = new int[K + 1][K + 1]; //i~j 만드는 최소비용

            for (int i = 1; i <= K; i++) {
                files[i] = sc.nextInt();
                sum[i] = sum[i - 1] + files[i];// 40 30 30 50 일 경우, 0 40 70 100 150 이렇게 저장됨
            }


            for (int length = 2; length <= K; length++) { // 구간 길이
                for (int i = 1; i <= K - length + 1; i++) {
                    int j = i + length - 1; //i : 시작점, j : 끝점
                    dp[i][j] = Integer.MAX_VALUE;

                    for (int k = i; k < j; k++) {
                        dp[i][j] = Math.min(dp[i][j], dp[i][k] + dp[k + 1][j] + sum[j] - sum[i - 1]);
                    }
                }
            }
            System.out.println(dp[1][K]);
        }
        sc.close();
    }
}

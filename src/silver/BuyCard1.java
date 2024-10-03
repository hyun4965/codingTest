package silver;

import java.io.*;
import java.util.Scanner;

public class BuyCard1 {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt(); // 카드의 개수 N
        int[] dp = new int[N+1]; // dp[i]는 i개의 카드를 구매하는 최대 비용을 저장

        // 각 카드팩의 가격을 입력받음
        for (int i = 1; i <= N; i++) {
            dp[i] = sc.nextInt();
        }

        // DP를 이용하여 최댓값 계산
        for (int i = 1; i <= N; i++) { // 카드팩의 크기를 하나씩 증가시킴
            for (int j = i; j <= N; j++) { // j는 현재 구매할 카드의 수
                // dp[j] = max(dp[j], dp[j-i] + dp[i])
                // 즉, j개를 사는데 드는 최대 비용은
                // 이전에 구해놓은 최대 비용과, i개를 추가했을 때의 비용 중 큰 값
                dp[j] = Math.max(dp[j], dp[j-i] + dp[i]);
            }
        }

        // N개의 카드를 구매하기 위해 지불해야 하는 최대 금액 출력
        System.out.println(dp[N]);
    }
}

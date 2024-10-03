package silver;

import java.util.*;

//백준 16194 실버 카드구매하기 2

public class BuyCard2 {
    public static void main(String[] args){
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
                // 즉, j개를 사는데 드는 최대 비용은
                // 이전에 구해놓은 최대 비용과, i개를 추가했을 때의 비용 중 큰 값
                //점화식과 같은 개념임
                //ex) 4일 경우 1+3, 2 + 2, 3+1 을 구해서 그중에 가장 작은 값으로 된다.
                dp[j] = Math.min(dp[j], dp[j-i] + dp[i]);
            }
        }

        // N개의 카드를 구매하기 위해 지불해야 하는 최대 금액 출력
        System.out.println(dp[N]);
    }
}

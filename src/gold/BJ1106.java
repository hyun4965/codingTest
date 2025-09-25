package gold;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BJ1106 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int C = Integer.parseInt(st.nextToken()); // 목표 고객 수
        int N = Integer.parseInt(st.nextToken()); // 도시의 개수

        int[] dp = new int[C + 101];
        Arrays.fill(dp, Integer.MAX_VALUE);
        dp[0] = 0;

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            int cost = Integer.parseInt(st.nextToken());
            int customers = Integer.parseInt(st.nextToken());

            if (customers > 0) {
                for (int j = customers; j < dp.length; j++) {
                    if (dp[j - customers] != Integer.MAX_VALUE) {
                        dp[j] = Math.min(dp[j], dp[j - customers] + cost);
                    }
                }
            }
        }

        int minCost = Integer.MAX_VALUE;
        for (int i = C; i < dp.length; i++) {
            minCost = Math.min(minCost, dp[i]);
        }

        System.out.println(minCost);
    }
}

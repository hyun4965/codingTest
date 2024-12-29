package gold;

import java.util.*;

public class BJ2565 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt(); // 전깃줄 개수

        int[][] wires = new int[N][2];
        for (int i = 0; i < N; i++) {
            wires[i][0] = sc.nextInt(); // A
            wires[i][1] = sc.nextInt(); // B
        }
        //A기준 정렬
        Arrays.sort(wires, Comparator.comparingInt(o -> o[0]));

        // LIS 계산 (B 전봇대 연결 순서를 기준으로)
        int[] dp = new int[N];
        int maxLength = 0;

        for (int i = 0; i < N; i++) {
            dp[i] = 1;
            for (int j = 0; j < i; j++) {
                if (wires[j][1] < wires[i][1]) {
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                }
            }
            maxLength = Math.max(maxLength, dp[i]);
        }

        System.out.println(N - maxLength);
    }
}

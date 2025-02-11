package gold;

import java.util.Scanner;

public class BJ2629 {
    static boolean[][] dp;
    static int[] weights;
    static int totalWeight;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt(); // 추 개수
        weights = new int[N];

        int sum = 0; // 총 무게의 합
        for (int i = 0; i < N; i++) {
            weights[i] = sc.nextInt();
            sum += weights[i];
        }

        totalWeight = sum;
        dp = new boolean[N + 1][sum + 1];

        dfs(0, 0);

        int M = sc.nextInt();
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < M; i++) {
            int marble = sc.nextInt();
            if (marble > totalWeight) {
                sb.append("N ");
            } else if (dp[N][marble]) {
                sb.append("Y ");
            } else {
                sb.append("N ");
            }
        }

        System.out.println(sb.toString().trim());
    }

    public static void dfs(int index, int weight) {
        if (index > weights.length || dp[index][weight]) return;
        dp[index][weight] = true;

        if (index < weights.length) {
            dfs(index + 1, weight); // 현재 추 사용 안함
            dfs(index + 1, weight + weights[index]); // 현재 추를 오른쪽에 추가
            dfs(index + 1, Math.abs(weight - weights[index])); // 현재 추를 왼쪽에 추가
        }
    }
}

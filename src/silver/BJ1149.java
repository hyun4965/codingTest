package silver;

import java.util.Scanner;

public class BJ1149 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        // 비용 배열 초기화 (각각 빨강, 초록, 파랑의 비용)
        int[][] color = new int[n + 1][3];
        for (int i = 1; i <= n; i++) {
            color[i][0] = sc.nextInt(); // 빨강 비용
            color[i][1] = sc.nextInt(); // 초록 비용
            color[i][2] = sc.nextInt(); // 파랑 비용
        }

        // DP 배열 초기화 (결과 저장)
        int[][] result = new int[n + 1][3];

        // 첫 번째 집 초기화
        result[1][0] = color[1][0];
        result[1][1] = color[1][1];
        result[1][2] = color[1][2];

        // DP 점화식 적용
        for (int i = 2; i <= n; i++) {
            result[i][0] = color[i][0] + Math.min(result[i - 1][1], result[i - 1][2]);
            result[i][1] = color[i][1] + Math.min(result[i - 1][0], result[i - 1][2]);
            result[i][2] = color[i][2] + Math.min(result[i - 1][0], result[i - 1][1]);
        }

        int minCost = Math.min(result[n][0], Math.min(result[n][1], result[n][2]));
        System.out.println(minCost);
    }
}

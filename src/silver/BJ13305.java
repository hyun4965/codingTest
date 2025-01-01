package silver;

import java.util.Scanner;

public class BJ13305 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt(); // 도시의 개수
        long[] length = new long[N - 1]; // 도로의 길이
        long[] cost = new long[N]; // 각 도시의 리터당 기름 가격

        // 도로 길이 입력
        for (int i = 0; i < N - 1; i++) {
            length[i] = sc.nextLong();
        }

        // 기름 가격 입력
        for (int i = 0; i < N; i++) {
            cost[i] = sc.nextLong();
        }

        long totalCost = 0; // 총 비용
        long minCost = cost[0]; // 현재까지의 최소 기름 가격

        // 각 도시를 순회하며 최소 비용 계산
        for (int i = 0; i < N - 1; i++) {
            // 현재 도시까지의 최소 기름 가격 유지
            if (cost[i] < minCost) {
                minCost = cost[i];
            }

            // 최소 가격으로 다음 도로 이동 비용 계산
            totalCost += minCost * length[i];
        }

        System.out.println(totalCost);
    }
}

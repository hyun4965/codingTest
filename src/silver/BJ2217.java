package silver;

import java.util.Scanner;
import java.util.Arrays;

public class BJ2217 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();
        int[] ropes = new int[N];

        for (int i = 0; i < N; i++) {
            ropes[i] = sc.nextInt();
        }

        // 로프의 중량을 내림차순으로 정렬
        Arrays.sort(ropes);

        int maxWeight = 0;

        for (int i = 0; i < N; i++) {
            // i번째 로프를 사용할 때 최대 중량 계산
            int weight = ropes[i] * (N - i);
            maxWeight = Math.max(maxWeight, weight);
        }

        System.out.println(maxWeight);
    }
}

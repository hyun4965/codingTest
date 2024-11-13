package middle2;

import java.util.Arrays;

public class A6_91 {

    // 최소 동전 개수를 구하는 함수
    public static int coinChange(int n, int[] coins) {
        int[] C = new int[n + 1];

        // 1. C 배열을 무한대로 초기화
        Arrays.fill(C, Integer.MAX_VALUE);
        C[0] = 0; // C[0]은 0으로 초기화 (0원을 만들기 위해 필요한 동전 수는 0)

        // 2. 동적 계획법을 사용하여 최소 동전 개수 계산
        for (int i = 1; i <= n; i++) { // i는 현재 금액
            for (int j = 1; j < coins.length; j++) { // j는 동전 종류 인덱스
                int dj = coins[j];
                if (i >= dj && C[i] > C[i - dj] + 1 ) {
                    C[i] = C[i - dj] + 1;
                }
            }
        }

        return C[n];
    }

    public static void main(String[] args) {
        int n = 11; // 거스름돈
        int[] coins = {0, 1, 5, 6, 8}; // 동전 종류

        int result = coinChange(n, coins);
        if (result != -1) {
            System.out.println("최소 동전 개수: " + result);
        } else {
            System.out.println("해당 금액을 만들 수 없습니다.");
        }
    }
}

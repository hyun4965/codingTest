package middle2;

import java.util.Arrays;

public class A6_91 {
    public static int coinChange(int n, int[] coins) {
        int[] C = new int[n + 1];
        Arrays.fill(C, Integer.MAX_VALUE); // 큰 값으로 초기화
        C[0] = 0; // 0원을 만들기 위한 동전 개수는 0

        // 점화식을 사용하여 최소 동전 개수 계산
        for (int j = 1; j <= n; j++) { // j는 현재 금액
            for (int i = 0; i < coins.length; i++) { // 각 동전 종류를 탐색
                int di = coins[i]; // 현재 동전의 액면가
                if (di <= j && C[j - di] + 1 < C[j]) {
                    C[j] = C[j - di] + 1;
                }
            }
        }

        // 결과 반환 (해당 금액을 만들 수 없는 경우 -1 반환)
        return C[n];
    }

    public static void main(String[] args) {
        int n = 620; // 예시 금액
        int[] coins = {500, 100, 50, 10, 1}; // 동전 종류 (내림차순으로 정렬되어 있다고 가정)

        int result = coinChange(n, coins);
        if (result != -1) {
            System.out.println(n + "원을 만드는데 필요한 최소 동전 개수: " + result);
        } else {
            System.out.println("해당 금액을 만들 수 없습니다.");
        }
    }
}
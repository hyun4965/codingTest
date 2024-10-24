package Algorithm;
import java.util.Arrays;
import java.util.Scanner;

public class CoinChange_DP {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // 입력 받기: n (금액), k (동전의 종류 개수)
        System.out.print("Enter the total amount (n): ");
        int n = scanner.nextInt();

        System.out.print("Enter the number of coin types (k): ");
        int k = scanner.nextInt();

        int[] coins = new int[k];

        System.out.println("Enter the coin denominations in descending order:");
        for (int i = 0; i < k; i++) {
            coins[i] = scanner.nextInt();
        }

        // DP 배열 초기화
        int[] C = new int[n + 1];
        Arrays.fill(C, Integer.MAX_VALUE); // 초기값을 무한대(최대값)로 설정
        C[0] = 0; // 금액이 0일 때는 동전이 필요하지 않음

        // 동전 사용하여 최소 개수 계산
        for (int j = 1; j <= n; j++) {
            for (int i = 0; i < k; i++) {
                if (coins[i] <= j && C[j - coins[i]] + 1 < C[j]) {
                    C[j] = C[j - coins[i]] + 1;
                }
            }
        }

        // 결과 출력
        if (C[n] == Integer.MAX_VALUE) {
            System.out.println("It is not possible to make the amount with the given coins.");
        } else {
            System.out.println("Minimum number of coins required: " + C[n]);
        }

        scanner.close();
    }
}

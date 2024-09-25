package silver;

import java.util.Scanner;

public class GCDPlus {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt(); // 테스트 케이스 수 입력

        for (int i = 0; i < t; i++) {
            int K = sc.nextInt();
            int[] arr = new int[K];
            long sum = 0; // GCD 합을 저장할 변수

            for (int j = 0; j < K; j++) {
                arr[j] = sc.nextInt();
            }

            // 가능한 모든 쌍에 대해 GCD 계산
            for (int k = 0; k < K; k++) {
                for (int m = k + 1; m < K; m++) {
                    sum += gcd(arr[k], arr[m]);
                }
            }

            System.out.println(sum); // 각 테스트 케이스의 GCD 합 출력
        }
        sc.close();
    }

    // 유클리드 호제법을 이용한 GCD 계산 함수
    public static int gcd(int a, int b) {
        if (b == 0) {
            return a;
        }
        return gcd(b, a % b);
    }
}


package silver;

import java.util.Scanner;

public class BertAndGongjun {
    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);
        int limit = 123456 * 2;
        boolean[] isPrime = new boolean[limit + 1];

        // 소수 판별 배열 초기화
        for (int i = 2; i <= limit; i++) {
            isPrime[i] = true;
        }

        // 에라토스테네스의 체 알고리즘으로 소수 판별
        for (int i = 2; i * i <= limit; i++) {
            if (isPrime[i]) {
                for (int j = i * i; j <= limit; j += i) {
                    isPrime[j] = false;
                }
            }
        }

        while (true) {
            int n = sc.nextInt();
            if (n == 0) break; // 입력이 0이면 종료

            int count = 0;
            for (int i = n + 1; i <= 2 * n; i++) {
                if (isPrime[i]) {
                    count++;
                }
            }

            System.out.println(count);
        }
    }
}

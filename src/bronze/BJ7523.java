package bronze;

import java.util.Scanner;

public class BJ7523 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int t = scanner.nextInt();
        for (int i = 1; i <= t; i++) {
            int n = scanner.nextInt();
            int m = scanner.nextInt();

            long sum = (long)(n + m) * (m - n + 1) / 2;

            System.out.println("Scenario #" + i + ":");
            System.out.println(sum);

            // 마지막 테스트 케이스는 빈 줄을 출력하지 않음
            if (i < t) {
                System.out.println();
            }
        }
    }
}

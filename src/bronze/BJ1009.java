package bronze;

import java.util.Scanner;

public class BJ1009 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt(); // 테스트 케이스 개수
        StringBuilder result = new StringBuilder();

        for (int t = 0; t < T; t++) {
            int a = sc.nextInt();
            int b = sc.nextInt();
            int mod = b % 4 == 0 ? 4 : b % 4; // 주기 계산
            int lastDigit = (int) Math.pow(a, mod) % 10; // 마지막 자리 계산
            result.append(lastDigit == 0 ? 10 : lastDigit).append("\n"); // 결과 저장
        }

        System.out.print(result.toString()); // 결과 출력
    }
}

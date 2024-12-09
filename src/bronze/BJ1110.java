package bronze;

import java.util.Scanner;

public class BJ1110 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // 입력받기
        int n = scanner.nextInt();
        scanner.close();

        int original = n; // 초기 값 저장
        int count = 0;    // 사이클 길이 초기화

        do {
            count++; // 연산 수행 시마다 카운트 증가

            // 각 자리의 합 계산
            int tens = n / 10;        // 십의 자리
            int ones = n % 10;        // 일의 자리
            int sum = tens + ones;    // 자리수 합

            // 새로운 수 생성
            n = (ones * 10) + (sum % 10);

        } while (n != original); // 원래 수로 돌아올 때까지 반복

        // 결과 출력
        System.out.println(count);
    }
}

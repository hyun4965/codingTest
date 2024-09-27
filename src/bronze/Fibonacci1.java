package bronze;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Fibonacci1 {

    static int code1Count = 0; // 재귀 호출의 코드1 실행 횟수
    static int code2Count = 0; // 동적 프로그래밍의 코드2 실행 횟수

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine()); // 예제 입력 (5 ≤ n ≤ 40)

        // 재귀 호출을 통한 피보나치 계산
        fib(n);

        // 동적 프로그래밍을 통한 피보나치 계산
        fibonacci(n);

        // 결과 출력
        System.out.println(code1Count + " " + code2Count);
    }

    // 재귀 호출을 통한 피보나치 계산
    public static int fib(int n) {
        if (n == 1 || n == 2) {
            code1Count++; // 코드1 실행 횟수 증가
            return 1;
        } else {
            return fib(n - 1) + fib(n - 2);
        }
    }

    // 동적 프로그래밍을 통한 피보나치 계산
    public static int fibonacci(int n) {
        int[] f = new int[n + 1];
        f[1] = f[2] = 1;
        for (int i = 3; i <= n; i++) {
            f[i] = f[i - 1] + f[i - 2];
            code2Count++; // 코드2 실행 횟수 증가
        }
        return f[n];
    }
}

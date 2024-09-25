package silver;

import java.util.Scanner;

public class HideAndSeek {
    // 두 수의 최대 공약수를 구하는 함수
    public static int gcd(int a, int b) {
        while (b != 0) {
            int temp = a % b;
            a = b;
            b = temp;
        }
        return a;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt(); // 동생의 수
        int S = sc.nextInt(); // 수빈이의 위치

        int[] positions = new int[N];

        // 동생들의 위치 입력받기
        for (int i = 0; i < N; i++) {
            positions[i] = sc.nextInt();
        }

        // 수빈이와 첫 번째 동생의 거리 차이를 기준으로 최대 공약수를 구하기 시작
        int result = Math.abs(positions[0] - S);

        // 나머지 동생들과의 거리 차이들에 대해 최대 공약수를 구함
        for (int i = 1; i < N; i++) {
            result = gcd(result, Math.abs(positions[i] - S));
        }

        // 가능한 D값의 최댓값 출력
        System.out.println(result);

        sc.close();
    }
}

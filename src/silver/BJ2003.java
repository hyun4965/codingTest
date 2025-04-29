package silver;

import java.util.Scanner;

public class BJ2003 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt(); // 수열의 길이
        int M = sc.nextInt(); // 목표 합
        int[] A = new int[N];

        for (int i = 0; i < N; i++) {
            A[i] = sc.nextInt();
        }

        int count = 0;
        int sum = 0;
        int start = 0;
        int end = 0;

        while (true) {
            if (sum >= M) {
                sum -= A[start++];
            } else if (end == N) {
                break;
            } else {
                sum += A[end++];
            }

            if (sum == M) {
                count++;
            }
        }

        System.out.println(count);
    }
}

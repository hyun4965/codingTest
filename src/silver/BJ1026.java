package silver;

import java.util.Arrays;
import java.util.Collections;
import java.util.Scanner;

public class BJ1026 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int[] A = new int[N];
        Integer[] B = new Integer[N];  // 내림차순 정렬을 위해 Integer 사용

        // A, B 입력
        for (int i = 0; i < N; i++) {
            A[i] = sc.nextInt();
        }
        for (int i = 0; i < N; i++) {
            B[i] = sc.nextInt();
        }

        // A는 오름차순 정렬, B는 내림차순 정렬
        Arrays.sort(A);
        Arrays.sort(B, Collections.reverseOrder());

        int result = 0;
        for (int i = 0; i < N; i++) {
            result += A[i] * B[i];
        }
        System.out.println(result);
    }
}

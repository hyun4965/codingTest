package gold;

import java.util.Scanner;

public class BJ11054 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int[] arr = new int[N];
        // 배열 입력받기
        for (int i = 0; i < N; i++) {
            arr[i] = sc.nextInt();
        }
        // 증가 수열
        int[] up = new int[N];
        for (int i = 0; i < N; i++) {
            up[i] = 1;
            for (int j = 0; j < i; j++) {
                if (arr[j] < arr[i]) {
                    up[i] = Math.max(up[i], up[j] + 1);
                }
            }
        }

        // 감소 수열
        int[] down = new int[N];
        for (int i = N - 1; i >= 0; i--) {
            down[i] = 1;
            for (int j = N - 1; j > i; j--) {
                if (arr[j] < arr[i]) {
                    down[i] = Math.max(down[i], down[j] + 1); // down 배열로 갱신
                }
            }
        }

        // 결과값 계산
        int max_length = 0;
        for (int i = 0; i < N; i++) {
            max_length = Math.max(max_length, up[i] + down[i] - 1);
        }

        System.out.println(max_length);
    }
}

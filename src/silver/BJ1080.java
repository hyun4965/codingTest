package silver;

import java.util.Scanner;

public class BJ1080 {
    static int N,M;
    static int[][] A;
    static int[][] B;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        M = sc.nextInt();

        A = new int[N][M];
        B = new int[N][M];

        // 행렬 A 입력
        for (int i = 0; i < N; i++) {
            String line = sc.next();
            for (int j = 0; j < M; j++) {
                A[i][j] = line.charAt(j) - '0';
            }
        }

        // 행렬 B 입력
        for (int i = 0; i < N; i++) {
            String line = sc.next();
            for (int j = 0; j < M; j++) {
                B[i][j] = line.charAt(j) - '0';
            }
        }


        int result = transform();
        System.out.println(result);
    }

    static int transform() {
        int count = 0;

        // 3x3 부분 행렬을 뒤집을 수 있는 범위에서 연산 수행
        for (int i = 0; i <= N - 3; i++) {
            for (int j = 0; j <= M - 3; j++) {
                if (A[i][j] != B[i][j]) {
                    flip(i, j);
                    count++;
                }
            }
        }

        // 변환 완료 후, A와 B가 같은지 확인
        if (isEqual()) {
            return count;
        } else {
            return -1;
        }
    }

    // 3x3 부분 행렬을 뒤집는 함수
    static void flip(int x, int y) {
        for (int i = x; i < x + 3; i++) {
            for (int j = y; j < y + 3; j++) {
                A[i][j] ^= 1; // 0 -> 1, 1 -> 0
            }
        }
    }

    // 변환된 A가 B와 동일한지 확인
    static boolean isEqual() {
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (A[i][j] != B[i][j]) {
                    return false;
                }
            }
        }
        return true;
    }
}
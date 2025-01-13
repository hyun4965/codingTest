package gold;

import java.util.Scanner;

public class BJ10830 {
    final static int MOD = 1000;
    static int[][] originArr;
    static int N;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        long B = sc.nextLong();

        originArr = new int[N][N];

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                originArr[i][j] = sc.nextInt() % MOD;
            }
        }

        int[][] result = pow(originArr, B);

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                System.out.print(result[i][j] + " ");
            }
            System.out.println();
        }
    }

    public static int[][] pow(int[][] matrix, long exp) {
        if (exp == 1) {
            return matrix;
        }

        int[][] half = pow(matrix, exp / 2);
        half = multiply(half, half);

        //홀수일 경우 .
        if (exp % 2 == 1) {
            half = multiply(half, originArr);
        }

        return half;
    }

    public static int[][] multiply(int[][] matrix1, int[][] matrix2) {
        int[][] result = new int[N][N];

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                for (int k = 0; k < N; k++) {
                    result[i][j] += matrix1[i][k] * matrix2[k][j];
                    result[i][j] %= MOD;
                }
            }
        }

        return result;
    }
}

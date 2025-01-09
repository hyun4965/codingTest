package silver;

import java.util.Scanner;

public class BJ1459 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        long X = sc.nextLong();
        long Y = sc.nextLong();
        int W = sc.nextInt();
        int S = sc.nextInt();

        // 1. 직선 이동만 하는 경우
        long straightCost = (X + Y) * W;

        // 2. 대각선 이동 + 남은 직선 이동
        long diagonalCost = Math.min(X, Y) * S + Math.abs(X - Y) * W;

        // 3. 대각선 이동만 사용하는 경우
        long fullDiagonalCost = 0;
        if ((X + Y) % 2 == 0) {
            fullDiagonalCost = Math.max(X, Y) * S;
        } else {
            fullDiagonalCost = (Math.max(X, Y) - 1) * S + W;
        }

        long minCost = Math.min(straightCost, Math.min(diagonalCost, fullDiagonalCost));
        System.out.println(minCost);
    }
}

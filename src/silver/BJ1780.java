package silver;

import java.util.Scanner;

public class BJ1780 {
    static int[][] paper;
    static int minus = 0, zero = 0, plus = 0;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        paper = new int[N][N];
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                paper[i][j] = sc.nextInt();
            }
        }

        cutpaper(0, 0, N);

        System.out.println(minus);
        System.out.println(zero);
        System.out.println(plus);
    }

    static void cutpaper(int x, int y, int size) {
        if (checkSame(x, y, size)) {
            int value = paper[x][y];
            //-1
            if (value == -1) {
                minus++;
            }
            //0
            if (value == 0) {
                zero++;
            }
            //+1
            if (value == 1) {
                plus++;
            }
            return;
        }

        int newSize = size / 3;
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                cutpaper(x + i * newSize, y + j * newSize, newSize);
            }
        }
    }

    static boolean checkSame(int x, int y, int size) {
        int value = paper[x][y];
        for (int i = x; i < x + size; i++) {
            for (int j = y; j < y + size; j++) {
                if (paper[i][j] != value) {
                    return false;
                }
            }
        }
        return true;
    }
}
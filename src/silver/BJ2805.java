package silver;

import java.util.Scanner;

public class BJ2805 {
    private static int whiteCount = 0;
    private static int blueCount = 0;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // 종이의 크기 N 입력
        int N = scanner.nextInt();
        int[][] paper = new int[N][N];

        // 종이의 색 입력 (0: 하얀색, 1: 파란색)
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                paper[i][j] = scanner.nextInt();
            }
        }

        // 종이를 나누는 함수 호출
        dividePaper(paper, 0, 0, N);

        System.out.println(whiteCount);
        System.out.println(blueCount);
    }

    private static void dividePaper(int[][] paper, int x, int y, int size) {
        if (isUniformColor(paper, x, y, size)) {
            if (paper[x][y] == 0) {
                whiteCount++;
            } else {
                blueCount++;
            }
        } else {
            int newSize = size / 2;
            dividePaper(paper, x, y, newSize);
            dividePaper(paper, x, y + newSize, newSize);
            dividePaper(paper, x + newSize, y, newSize);
            dividePaper(paper, x + newSize, y + newSize, newSize);
        }
    }

    private static boolean isUniformColor(int[][] paper, int x, int y, int size) {
        int color = paper[x][y];
        for (int i = x; i < x + size; i++) {
            for (int j = y; j < y + size; j++) {
                if (paper[i][j] != color) {
                    return false;
                }
            }
        }
        return true; // 모두 같은 색이면 true
    }
}

package gold;

import java.util.Scanner;

public class BJ2448 {
    static char[][] arr;
    static int N;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        N = n;
        int width = 2 * n - 1;
        arr = new char[n][width];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < width; j++) {
                arr[i][j] = ' ';
            }
        }

        draw(0, 0, n);

        for (int i = 0; i < n; i++) {
            System.out.println(new String(arr[i]));
        }
        sc.close();
    }

    static void draw(int r, int c, int size) {
        if (size == 3) {
            arr[r][c+2] = '*';
            arr[r+1][c+1] = '*';
            arr[r+1][c+3] = '*';
            for (int i = 0; i < 5; i++) {
                arr[r+2][c+i] = '*';
            }
        } else {
            int newSize = size / 2;
            // 상단 삼각형 (중앙 정렬)
            draw(r, c + newSize, newSize);
            // 좌측 하단 삼각형
            draw(r + newSize, c, newSize);
            // 우측 하단 삼각형
            draw(r + newSize, c + newSize * 2, newSize);
        }
    }
}

package gold;

import java.util.Scanner;

public class BJ14890 {
    static int[][] map;
    static int n;
    static int l;
    static int result = 0;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        map = new int[n][n];
        l = sc.nextInt(); //경사로 L의 길이
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                map[i][j] = sc.nextInt();
            }
        }
        for (int i = 0; i < n; i++) {
            checkRow(i);
            checkCol(i);
        }
        System.out.println(result);
    }

    private static void checkRow(int row) {
        boolean[] isTrue = new boolean[n];

        for (int i = 0; i < n - 1; i++) {
            int diff = map[row][i] - map[row][i+1];

            if (Math.abs(diff) > 1) {
                return;
            }
            //내리막
            if (diff == 1) {
                for (int j = 1; j <= l; j++) {
                    if (i + j >= n || map[row][i+1] != map[row][i+j] || isTrue[i+j]) {
                        return;
                    }
                    isTrue[i+j] = true;
                }
            }else if (diff == -1) { //오르막
                for (int j = 0; j < l; j++) {
                    if (i - j < 0 || map[row][i] != map[row][i-j] || isTrue[i-j]) {
                        return;
                    }
                    isTrue[i-j] = true;
                }
            }
        }
        result++;
    }

    private static void checkCol(int col) {
        boolean[] isTrue = new boolean[n];

        for (int i = 0; i < n - 1; i++) {
            int diff = map[i][col] - map[i+1][col];

            if (Math.abs(diff) > 1) {
                return;
            }
            //내리막
            if (diff == 1) {
                for (int j = 1; j <= l; j++) {
                    if (i + j >= n || map[i+1][col] != map[i+j][col] || isTrue[i+j]) {
                        return;
                    }
                    isTrue[i+j] = true;
                }
            } else if (diff == -1) { //오르막
                for (int j = 0; j < l; j++) {
                    if (i - j < 0 || map[i][col] != map[i-j][col] || isTrue[i-j]) {
                        return;
                    }
                    isTrue[i-j] = true;
                }
            }
        }
        result++;
    }
}
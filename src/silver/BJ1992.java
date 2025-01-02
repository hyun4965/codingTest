package silver;

import java.util.Scanner;

public class BJ1992 {
    static int[][] video;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        sc.nextLine();

        video = new int[N][N];

        for (int i = 0; i < N; i++) {
            String line = sc.nextLine();
            for (int j = 0; j < N; j++) {
                video[i][j] = line.charAt(j) - '0';
            }
        }

        System.out.println(compress(0, 0, N));
    }

    private static String compress(int x, int y, int size) {
        if (isUniform(x, y, size)) {
            return String.valueOf(video[x][y]);
        }

        int half = size / 2;
        StringBuilder sb = new StringBuilder();
        sb.append("(");
        sb.append(compress(x, y, half));
        sb.append(compress(x, y + half, half));
        sb.append(compress(x + half, y, half));
        sb.append(compress(x + half, y + half, half));
        sb.append(")");

        return sb.toString();
    }

    private static boolean isUniform(int x, int y, int size) {
        int value = video[x][y];
        for (int i = x; i < x + size; i++) {
            for (int j = y; j < y + size; j++) {
                if (video[i][j] != value) {
                    return false;
                }
            }
        }
        return true;
    }
}

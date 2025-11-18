package silver;

import java.util.Scanner;

public class BJ2669 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        boolean[][] map = new boolean[101][101];

        for (int i = 0; i < 4; i++) {
            int lx = sc.nextInt();
            int ly = sc.nextInt();
            int rx = sc.nextInt();
            int ry = sc.nextInt();

            for (int x = lx; x < rx; x++) {
                for (int y = ly; y < ry; y++) {
                    map[x][y] = true;
                }
            }
        }

        int area = 0;
        for (int x = 1; x <= 100; x++) {
            for (int y = 1; y <= 100; y++) {
                if (map[x][y]) {
                    area++;
                }
            }
        }

        System.out.println(area);
    }
}

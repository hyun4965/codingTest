package gold;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class BJ15685 {
    private static final int RIGHT = 0;
    private static final int UP = 1;
    private static final int LEFT = 2;
    private static final int DOWN = 3;
    private static final int SIZE = 101;

    private static boolean[][] map = new boolean[SIZE][SIZE];

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();

        while (N-- > 0) {
            int x = sc.nextInt();
            int y = sc.nextInt();
            int d = sc.nextInt();
            int g = sc.nextInt();

            draw(x, y, getDirections(d, g));
        }

        System.out.println(getNumberOfSquares());
    }

    public static List<Integer> getDirections(int d, int g) {
        List<Integer> directions = new ArrayList<>();
        directions.add(d);

        while (g-- > 0) {
            for (int i = directions.size() - 1; i >= 0; i--) {
                int direction = (directions.get(i) + 1) % 4;
                directions.add(direction);
            }
        }
        return directions;
    }

    public static void draw(int x, int y, List<Integer> directions) {
        map[x][y] = true;

        for (int direction : directions) {
            switch (direction) {
                case RIGHT:
                    map[++x][y] = true;
                    break;
                case UP:
                    map[x][--y] = true;
                    break;
                case LEFT:
                    map[--x][y] = true;
                    break;
                case DOWN:
                    map[x][++y] = true;
                    break;
            }
        }
    }

    private static int getNumberOfSquares() {
        int count = 0;

        for (int x = 0; x < SIZE -1; x++) {
            for (int y = 0; y < SIZE -1; y++) {
                if (map[x][y] && map[x + 1][y] && map[x][y + 1] && map[x + 1][y + 1])
                    count++;
            }
        }

        return count;
    }
}

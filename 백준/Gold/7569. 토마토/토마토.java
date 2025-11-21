import java.util.Scanner;
import java.util.LinkedList;
import java.util.Queue;

public class Main {
    static class Point {
        int x, y, z;

        public Point(int x, int y, int z) {
            this.x = x;
            this.y = y;
            this.z = z;
        }
    }
    static int M,N,H;
    static int[][][] box;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        M = sc.nextInt(); 
        N = sc.nextInt();
        H = sc.nextInt(); 

        box = new int[H][N][M];
        Queue<Point> queue = new LinkedList<>();

        for (int h = 0; h < H; h++) {
            for (int n = 0; n < N; n++) {
                for (int m = 0; m < M; m++) {
                    box[h][n][m] = sc.nextInt();
                    if (box[h][n][m] == 1) {
                        queue.add(new Point(m, n, h));
                    }
                }
            }
        }

        int[] dx = {1, -1, 0, 0, 0, 0};
        int[] dy = {0, 0, 1, -1, 0, 0};
        int[] dz = {0, 0, 0, 0, 1, -1};

        int days = 0;

        while (!queue.isEmpty()) {
            int size = queue.size();
            boolean ripened = false;

            for (int i = 0; i < size; i++) {
                Point p = queue.poll();

                for (int d = 0; d < 6; d++) {
                    int nx = p.x + dx[d];
                    int ny = p.y + dy[d];
                    int nz = p.z + dz[d];

                    if (nx >= 0 && nx < M && ny >= 0 && ny < N && nz >= 0 && nz < H && box[nz][ny][nx] == 0) {
                        box[nz][ny][nx] = 1;
                        queue.add(new Point(nx, ny, nz));
                        ripened = true;
                    }
                }
            }

            if (ripened) {
                days++;
            }
        }

        for (int h = 0; h < H; h++) {
            for (int n = 0; n < N; n++) {
                for (int m = 0; m < M; m++) {
                    if (box[h][n][m] == 0) {
                        System.out.println(-1);
                        return;
                    }
                }
            }
        }

        System.out.println(days);
    }
}
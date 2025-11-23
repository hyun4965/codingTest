package news;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class BJ7569 {
    static int M, N, H;
    static int[][][] box;
    static int[] dx = {1, -1, 0, 0, 0, 0};
    static int[] dy = {0, 0, 1, -1, 0, 0};
    static int[] dz = {0, 0, 0, 0, 1, -1};

    static Queue<int[]> queue = new LinkedList<>();

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        M = sc.nextInt();
        N = sc.nextInt();
        H = sc.nextInt();

        box = new int[H][N][M];

        for (int h = 0; h < H; h++) {
            for (int n = 0; n < N; n++) {
                for (int m = 0; m < M; m++) {
                    box[h][n][m] = sc.nextInt();
                    if (box[h][n][m] == 1) {
                        queue.add(new int[]{m, n, h});
                    }
                }
            }
        }

        bfs();

        System.out.println(getResult());

        sc.close();
    }

    static void bfs() {
        while (!queue.isEmpty()) {
            int[] cur = queue.poll();
            int cx = cur[0];
            int cy = cur[1];
            int cz = cur[2];

            for (int i = 0; i < 6; i++) {
                int nx = cx + dx[i];
                int ny = cy + dy[i];
                int nz = cz + dz[i];

                if (nx >= 0 && nx < M && ny >= 0 && ny < N && nz >= 0 && nz < H) {
                    if (box[nz][ny][nx] == 0) {
                        box[nz][ny][nx] = box[cz][cy][cx] + 1;
                        queue.add(new int[]{nx, ny, nz});
                    }
                }
            }
        }
    }

    static int getResult() {
        int maxDays = 0;

        for (int h = 0; h < H; h++) {
            for (int n = 0; n < N; n++) {
                for (int m = 0; m < M; m++) {
                    if (box[h][n][m] == 0) {
                        return -1;
                    }
                    maxDays = Math.max(maxDays, box[h][n][m]);
                }
            }
        }

        return maxDays - 1;
    }
}
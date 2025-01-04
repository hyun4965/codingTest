package gold;

import java.util.Scanner;
import java.util.LinkedList;
import java.util.Queue;

public class BJ7569 {
    static class Point {
        int x, y, z;

        public Point(int x, int y, int z) {
            this.x = x;
            this.y = y;
            this.z = z;
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int M = sc.nextInt(); // 가로 칸 수
        int N = sc.nextInt(); // 세로 칸 수
        int H = sc.nextInt(); // 상자의 수

        int[][][] box = new int[H][N][M];
        Queue<Point> queue = new LinkedList<>();

        // 입력 받기 및 익은 토마토 위치 큐에 저장
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

        // 방향 벡터 정의 (위, 아래, 왼쪽, 오른쪽, 앞, 뒤)
        int[] dx = {1, -1, 0, 0, 0, 0};
        int[] dy = {0, 0, 1, -1, 0, 0};
        int[] dz = {0, 0, 0, 0, 1, -1};

        int days = 0;

        // BFS 수행
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

        // 익지 않은 토마토가 있는지 확인
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
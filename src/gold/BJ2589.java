package gold;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BJ2589 {

    static int N, M; // 세로, 가로 크기
    static char[][] map; // 보물 지도
    static int[] dx = { -1, 1, 0, 0 };
    static int[] dy = { 0, 0, -1, 1 };

    static class Point {
        int x, y;

        public Point(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        map = new char[N][M];
        for (int i = 0; i < N; i++) {
            map[i] = br.readLine().toCharArray();
        }

        int maxDistance = 0;

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (map[i][j] == 'L') {
                    maxDistance = Math.max(maxDistance, bfs(i, j));
                }
            }
        }

        System.out.println(maxDistance);
    }

    private static int bfs(int startX, int startY) {
        Queue<Point> queue = new LinkedList<>();
        int[][] distance = new int[N][M];
        for (int i = 0; i < N; i++) {
            for(int j=0; j<M; j++){
                distance[i][j] = -1;
            }
        }

        queue.add(new Point(startX, startY));
        distance[startX][startY] = 0;

        int currentMax = 0;

        while (!queue.isEmpty()) {
            Point current = queue.poll();

            for (int i = 0; i < 4; i++) {
                int nextX = current.x + dx[i];
                int nextY = current.y + dy[i];

                if (nextX < 0 || nextX >= N || nextY < 0 || nextY >= M) {
                    continue;
                }

                if (map[nextX][nextY] == 'L' && distance[nextX][nextY] == -1) {
                    distance[nextX][nextY] = distance[current.x][current.y] + 1;
                    queue.add(new Point(nextX, nextY));
                    currentMax = Math.max(currentMax, distance[nextX][nextY]);
                }
            }
        }

        return currentMax;
    }
}
package gold;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BJ3055 {

    static int R, C;
    static char[][] map;
    static Queue<Point> hedgehogQueue = new LinkedList<>();
    static Queue<Point> waterQueue = new LinkedList<>();
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};
    static Point destination;

    static class Point {
        int x, y, time;

        Point(int x, int y, int time) {
            this.x = x;
            this.y = y;
            this.time = time;
        }

        Point(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        R = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());

        map = new char[R][C];
        for (int i = 0; i < R; i++) {
            String line = br.readLine();
            for (int j = 0; j < C; j++) {
                map[i][j] = line.charAt(j);
                if (map[i][j] == 'S') {
                    hedgehogQueue.add(new Point(i, j, 0));
                } else if (map[i][j] == '*') {
                    waterQueue.add(new Point(i, j));
                } else if (map[i][j] == 'D') {
                    destination = new Point(i, j);
                }
            }
        }

        int result = bfs();
        if (result == -1) {
            System.out.println("KAKTUS");
        } else {
            System.out.println(result);
        }
    }

    static int bfs() {
        while (!hedgehogQueue.isEmpty()) {
            int waterSize = waterQueue.size();
            for (int i = 0; i < waterSize; i++) {
                Point water = waterQueue.poll();
                for (int d = 0; d < 4; d++) {
                    int nx = water.x + dx[d];
                    int ny = water.y + dy[d];

                    if (nx >= 0 && ny >= 0 && nx < R && ny < C && map[nx][ny] == '.') {
                        map[nx][ny] = '*';
                        waterQueue.add(new Point(nx, ny));
                    }
                }
            }

            int hedgehogSize = hedgehogQueue.size();
            for (int i = 0; i < hedgehogSize; i++) {
                Point hedgehog = hedgehogQueue.poll();

                for (int d = 0; d < 4; d++) {
                    int nx = hedgehog.x + dx[d];
                    int ny = hedgehog.y + dy[d];

                    if (nx >= 0 && ny >= 0 && nx < R && ny < C) {
                        if (map[nx][ny] == 'D') {
                            return hedgehog.time + 1;
                        }
                        if (map[nx][ny] == '.') {
                            map[nx][ny] = 'S';
                            hedgehogQueue.add(new Point(nx, ny, hedgehog.time + 1));
                        }
                    }
                }
            }
        }
        return -1;
    }
}

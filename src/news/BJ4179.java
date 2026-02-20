package news;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BJ4179 {
    static int r, c;
    static char[][] map;
    static Queue<int[]> jihunQueue = new LinkedList<>();
    static Queue<int[]> fireQueue = new LinkedList<>();
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};
    static boolean[][] visited;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        r = Integer.parseInt(st.nextToken());
        c = Integer.parseInt(st.nextToken());

        map = new char[r][c];
        visited = new boolean[r][c];

        for (int i = 0; i < r; i++) {
            String line = br.readLine();
            for (int j = 0; j < c; j++) {
                map[i][j] = line.charAt(j);
                if (map[i][j] == 'J') {
                    jihunQueue.add(new int[]{i, j});
                    visited[i][j] = true;
                } else if (map[i][j] == 'F') {
                    fireQueue.add(new int[]{i, j});
                }
            }
        }

        int result = bfs();

        if (result == -1) {
            System.out.println("IMPOSSIBLE");
        } else {
            System.out.println(result);
        }
    }

    static int bfs() {
        int time = 0;
        while (!jihunQueue.isEmpty()) {
            time++;

            int fireSize = fireQueue.size();
            for (int i = 0; i < fireSize; i++) {
                int[] pos = fireQueue.poll();
                for (int d = 0; d < 4; d++) {
                    int nx = pos[0] + dx[d];
                    int ny = pos[1] + dy[d];

                    if (nx >= 0 && nx < r && ny >= 0 && ny < c) {
                        if (map[nx][ny] == '.' || map[nx][ny] == 'J') {
                            map[nx][ny] = 'F';
                            fireQueue.add(new int[]{nx, ny});
                        }
                    }
                }
            }

            int jihunSize = jihunQueue.size();
            for (int i = 0; i < jihunSize; i++) {
                int[] pos = jihunQueue.poll();

                for (int d = 0; d < 4; d++) {
                    int nx = pos[0] + dx[d];
                    int ny = pos[1] + dy[d];

                    if (nx < 0 || nx >= r || ny < 0 || ny >= c) {
                        return time;
                    }

                    if (map[nx][ny] == '.' && !visited[nx][ny]) {
                        visited[nx][ny] = true;
                        jihunQueue.add(new int[]{nx, ny});
                    }
                }
            }
        }

        return -1;
    }
}

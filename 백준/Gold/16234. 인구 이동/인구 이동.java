import java.io.*;
import java.util.*;

public class Main {
    static int n, l, r;
    static int[][] map;
    static boolean[][] visited;

    static final int[] dx = {-1, 1, 0, 0};
    static final int[] dy = {0, 0, -1, 1};

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        l = Integer.parseInt(st.nextToken());
        r = Integer.parseInt(st.nextToken());

        map = new int[n][n];
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        int days = 0;

        while (true) {
            visited = new boolean[n][n];
            boolean moved = false;

            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    if (!visited[i][j]) {
                        List<int[]> list = new ArrayList<>();
                        int sum = bfs(i, j, list);

                        if (list.size() >= 2) {
                            moved = true;
                            int avg = sum / list.size();
                            for (int[] cell : list) {
                                map[cell[0]][cell[1]] = avg;
                            }
                        }
                    }
                }
            }

            if (!moved) {
                break;
            }
            days++;
        }

        System.out.println(days);
    }

    static int bfs(int sx, int sy, List<int[]> list) {
        Queue<int[]> q = new ArrayDeque<>();
        q.add(new int[]{sx, sy});
        visited[sx][sy] = true;

        list.add(new int[]{sx, sy});
        int sum = map[sx][sy];

        while (!q.isEmpty()) {
            int[] cur = q.poll();
            int x = cur[0];
            int y = cur[1];

            for (int dir = 0; dir < 4; dir++) {
                int nx = x + dx[dir];
                int ny = y + dy[dir];

                if (nx < 0 || ny < 0 || nx >= n || ny >= n) {
                    continue;
                }
                if (visited[nx][ny]) {
                    continue;
                }

                int diff = Math.abs(map[x][y] - map[nx][ny]);
                if (diff < l || diff > r) {
                    continue;
                }

                visited[nx][ny] = true;
                q.add(new int[]{nx, ny});
                list.add(new int[]{nx, ny});
                sum += map[nx][ny];
            }
        }

        return sum;
    }
}

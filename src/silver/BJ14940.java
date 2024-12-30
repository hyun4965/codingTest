package silver;

import java.util.*;

public class BJ14940 {
    static int[][] map;
    static int[][] distances;
    static boolean[][] visited;
    private static final int[] dx = {0, 0, 1, -1};
    private static final int[] dy = {1, -1, 0, 0};

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int m = sc.nextInt();
        map = new int[n][m];
        distances = new int[n][m];
        visited = new boolean[n][m];

        Queue<int[]> queue = new LinkedList<>();
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                map[i][j] = sc.nextInt();
                if (map[i][j] == 2) {
                    queue.add(new int[]{i, j});
                    visited[i][j] = true;
                    distances[i][j] = 0; // 시작점 초기화
                }
                if (map[i][j] == 0) {
                    distances[i][j] = 0; // 이동할 수 없는 지점은 0
                } else {
                    distances[i][j] = -1; // 초기값 -1
                }
            }
        }

        bfs(queue, n, m);

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                System.out.print(distances[i][j] + " ");
            }
            System.out.println();
        }
    }

    public static void bfs(Queue<int[]> queue, int n, int m) {
        while (!queue.isEmpty()) {
            int[] current = queue.poll();
            int x = current[0];
            int y = current[1];

            for (int i = 0; i < 4; i++) {
                int nx = x + dx[i];
                int ny = y + dy[i];

                if (nx >= 0 && ny >= 0 && nx < n && ny < m && !visited[nx][ny] && map[nx][ny] == 1) {
                    visited[nx][ny] = true;
                    distances[nx][ny] = distances[x][y] + 1;
                    queue.add(new int[]{nx, ny});
                }
            }
        }

        // BFS 완료 후 도달할 수 없는 땅 처리
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (!visited[i][j] && map[i][j] == 1) {
                    distances[i][j] = -1; // 도달 불가
                }
            }
        }
    }

}

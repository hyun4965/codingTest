package silver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;

public class BJ1926 {

    static int n, m;
    static int[][] board;
    static boolean[][] visited;

    static final int[] dx = {-1, 1, 0, 0};
    static final int[] dy = {0, 0, -1, 1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] firstLine = br.readLine().split(" ");
        n = Integer.parseInt(firstLine[0]);
        m = Integer.parseInt(firstLine[1]);

        board = new int[n][m];
        visited = new boolean[n][m];

        for (int i = 0; i < n; i++) {
            String[] line = br.readLine().split(" ");
            for (int j = 0; j < m; j++) {
                board[i][j] = Integer.parseInt(line[j]);
            }
        }

        int pictureCount = 0; //그림 갯수
        int maxArea = 0; //가장 넓은 그림의 넓이

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (board[i][j] == 1 && !visited[i][j]) { //1이거나 방문 X
                    pictureCount++;
                    int area = bfs(i, j);
                    maxArea = Math.max(maxArea, area);
                }
            }
        }

        System.out.println(pictureCount);
        System.out.println(maxArea);
    }

    private static int bfs(int sx, int sy) {
        Queue<int[]> q = new ArrayDeque<>();
        visited[sx][sy] = true;
        q.offer(new int[]{sx, sy});

        int area = 1;

        while (!q.isEmpty()) {
            int[] cur = q.poll();
            int x = cur[0];
            int y = cur[1];

            for (int dir = 0; dir < 4; dir++) {
                int nx = x + dx[dir];
                int ny = y + dy[dir];

                if (nx < 0 || nx >= n || ny < 0 || ny >= m) {
                    continue;
                }
                if (visited[nx][ny]) {
                    continue;
                }
                if (board[nx][ny] == 0) {
                    continue;
                }

                visited[nx][ny] = true;
                q.offer(new int[]{nx, ny});
                area++;
            }
        }
        return area;
    }
}

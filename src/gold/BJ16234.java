package gold;

import java.util.*;

public class BJ16234 {
    static int N, L, R;
    static int[][] map;
    static boolean[][] visited;

    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};

    static class Pos {
        int x, y;
        Pos(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        L = sc.nextInt();
        R = sc.nextInt();

        map = new int[N][N];

        for (int i = 0; i < N; i++)
            for (int j = 0; j < N; j++)
                map[i][j] = sc.nextInt();

        int days = 0;

        while (true) {
            visited = new boolean[N][N];
            boolean isMoved = false;

            for (int i = 0; i < N; i++) {
                for (int j = 0; j < N; j++) {
                    if (!visited[i][j]) {
                        if (bfs(i, j)) {
                            isMoved = true;
                        }
                    }
                }
            }

            if (!isMoved) {
                break;
            }
            days++;
        }

        System.out.println(days);
    }

    static boolean bfs(int x, int y) {
        Queue<Pos> queue = new LinkedList<>();
        List<Pos> union = new ArrayList<>();

        queue.offer(new Pos(x, y));
        union.add(new Pos(x, y));
        visited[x][y] = true;

        int sum = map[x][y];

        while (!queue.isEmpty()) {
            Pos current = queue.poll();

            for (int dir = 0; dir < 4; dir++) {
                int nx = current.x + dx[dir];
                int ny = current.y + dy[dir];

                if (nx >= 0 && ny >= 0 && nx < N && ny < N && !visited[nx][ny]) {
                    int diff = Math.abs(map[current.x][current.y] - map[nx][ny]);
                    if (diff >= L && diff <= R) {
                        visited[nx][ny] = true;
                        queue.offer(new Pos(nx, ny));
                        union.add(new Pos(nx, ny));
                        sum += map[nx][ny];
                    }
                }
            }
        }

        if (union.size() > 1) {
            int avg = sum / union.size();
            for (Pos p : union) {
                map[p.x][p.y] = avg;
            }
            return true;
        }

        return false;
    }
}

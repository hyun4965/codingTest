package silver;

import java.util.*;

public class BJ2583 {
    static int[][] arr;
    static boolean[][] visited;
    static int M, N, K;
    static int[] dx = {0, 0, 1, -1}; // 상하좌우 이동
    static int[] dy = {1, -1, 0, 0};

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        M = sc.nextInt(); //가로
        N = sc.nextInt(); //세로
        K = sc.nextInt();

        arr = new int[M][N];
        visited = new boolean[M][N];

        for (int i = 0; i < K; i++) {
            int x1 = sc.nextInt();
            int y1 = sc.nextInt();
            int x2 = sc.nextInt();
            int y2 = sc.nextInt();

            for (int y = y1; y < y2; y++) {
                for (int x = x1; x < x2; x++) {
                    arr[y][x] = 1;
                }
            }
        }
        List<Integer> areaList = new ArrayList<>();

        for (int i = 0; i < M; i++) {
            for (int j = 0; j < N; j++) {
                if (arr[i][j] == 0 && !visited[i][j]) {
                    int area = bfs(i, j);
                    areaList.add(area);
                }
            }
        }
        Collections.sort(areaList);

        System.out.println(areaList.size());
        for (int a : areaList) {
            System.out.print(a + " ");
        }
    }

    public static int bfs(int startY, int startX) {
        Queue<int[]> queue = new LinkedList<>();
        queue.offer(new int[] {startY, startX});
        visited[startY][startX] = true;
        int count = 1;

        while (!queue.isEmpty()) {
            int[] current = queue.poll();
            int y = current[0];
            int x = current[1];

            for (int dir = 0; dir < 4; dir++) {
                int ny = y + dy[dir];
                int nx = x + dx[dir];

                if (nx >= 0 && ny >= 0 && nx < N && ny < M) {
                    if (arr[ny][nx] == 0 && !visited[ny][nx]) {
                        visited[ny][nx] = true;
                        queue.offer(new int[] {ny, nx});
                        count++;
                    }
                }
            }
        }

        return count;
    }
}

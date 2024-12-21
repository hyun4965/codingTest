package silver;

import java.util.*;

public class BJ2667 {

    static int N;
    static int[][] map;
    static boolean[][] visited;
    static int[][] d = {{0, -1},{0, 1},{-1, 0},{1, 0}};
    static List<Integer> complexSizes;

    public static void main(String[] args) {
        insert();
        bfs();
        printf();
    }
    public static void insert() {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        map = new int[N][N];
        visited = new boolean[N][N];
        complexSizes = new ArrayList<>();

        for (int i = 0; i < N; i++) {
            String line = sc.next();
            for (int j = 0; j < N; j++) {
                map[i][j] = line.charAt(j) - '0';
            }
        }
    }

    public static void bfs() {
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (map[i][j] == 1 && !visited[i][j]) {
                    Queue<int[]> queue = new LinkedList<>();
                    queue.offer(new int[]{i, j});
                    visited[i][j] = true;
                    int count = 1;

                    while (!queue.isEmpty()) {
                        int[] current = queue.poll();
                        int cx = current[0];
                        int cy = current[1];

                        for (int[] direction : d) {
                            int nx = cx + direction[0];
                            int ny = cy + direction[1];

                            if (nx >= 0 && ny >= 0 && nx < N && ny < N && !visited[nx][ny] && map[nx][ny] == 1) {
                                queue.offer(new int[]{nx, ny});
                                visited[nx][ny] = true;
                                count++;
                            }
                        }
                    }
                    complexSizes.add(count);
                }
            }
        }
    }

    public static void printf() {
        System.out.println(complexSizes.size());
        Collections.sort(complexSizes);
        for (int size : complexSizes) {
            System.out.println(size);
        }
    }
}

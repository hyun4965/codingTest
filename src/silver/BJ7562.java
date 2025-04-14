package silver;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class BJ7562 {
    static int n;
    static int[][] graph;
    static boolean[][] visited;
    static int[][] pos = {{-2, 1}, {-1, 2}, {1, 2}, {2, 1}, {2, -1}, {1, -2}, {-1, -2}, {-2, -1}};
    static int nowX, nowY;
    static int desX, desY;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();

        for (int i = 0; i < T; i++) {
            n = sc.nextInt();
            graph = new int[n][n];
            visited = new boolean[n][n];

            nowX = sc.nextInt(); //현재 위치 (x)
            nowY = sc.nextInt(); //현재 위치 (y)
            desX = sc.nextInt(); //도착 위치 (x)
            desY = sc.nextInt(); //도착 위치 (y)

            visited[nowX][nowY] = true;
            bfs(nowX, nowY);
            System.out.println(graph[desX][desY]);

        }
    }
    static void bfs(int x, int y) {
        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[]{x, y});

        while(!queue.isEmpty()) {
            int[] now = queue.poll();
            int nowX = now[0];
            int nowY = now[1];

            for(int i=0; i<pos.length; i++) {
                int nX = nowX + pos[i][0];
                int nY = nowY + pos[i][1];

                if(nX < 0 || nX >= n || nY < 0 || nY >= n || visited[nX][nY] || graph[nX][nY] != 0) {
                    continue;
                }

                visited[nX][nY] = true;
                graph[nX][nY] = graph[nowX][nowY] + 1;
                queue.add(new int[] {nX, nY});
            }
        }
    }
}

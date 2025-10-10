package gold;

import java.io.*;
import java.util.*;

public class BJ4485 {
    static final int INF = 1000000000;
    static final int[] dx = {-1, 1, 0, 0};
    static final int[] dy = {0, 0, -1, 1};

    static class Node implements Comparable<Node> {
        int x;
        int y;
        int cost;

        Node(int x, int y, int cost) {
            this.x = x;
            this.y = y;
            this.cost = cost;
        }
        public int compareTo(Node o) {
            return Integer.compare(this.cost, o.cost);
        }
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        int tcase = 1;
        while (true) {
            int n = Integer.parseInt(br.readLine().trim());
            if (n == 0) break;

            int[][] cave = new int[n][n];
            for (int i = 0; i < n; i++) {
                st = new StringTokenizer(br.readLine());
                for (int j = 0; j < n; j++) {
                    cave[i][j] = Integer.parseInt(st.nextToken());
                }
            }

            int answer = dijkstra(cave);
            sb.append("Problem ").append(tcase++).append(": ").append(answer).append('\n');
        }
        System.out.print(sb);
    }

    static int dijkstra(int[][] cave) {
        int n = cave.length;
        int[][] dist = new int[n][n];
        for (int[] row : dist) {
            Arrays.fill(row, INF);
        }

        PriorityQueue<Node> pq = new PriorityQueue<>();
        dist[0][0] = cave[0][0];
        pq.offer(new Node(0, 0, dist[0][0]));

        while (!pq.isEmpty()) {
            Node cur = pq.poll();
            if (cur.cost > dist[cur.x][cur.y]) {
                continue;
            }
            if (cur.x == n - 1 && cur.y == n - 1) {
                return cur.cost;
            }

            for (int dir = 0; dir < 4; dir++) {
                int nx = cur.x + dx[dir];
                int ny = cur.y + dy[dir];
                if (nx < 0 || ny < 0 || nx >= n || ny >= n) {
                    continue;
                }

                int nextCost = cur.cost + cave[nx][ny];
                if (nextCost < dist[nx][ny]) {
                    dist[nx][ny] = nextCost;
                    pq.offer(new Node(nx, ny, nextCost));
                }
            }
        }
        return dist[n - 1][n - 1];
    }

}

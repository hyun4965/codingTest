package gold;

import java.util.PriorityQueue;
import java.util.Scanner;
import java.util.Arrays;

public class BJ1261 {

    static int m, n;
    static int[][] miro;
    static int[][] dist;
    static int[] dx = {0, 0, 1, -1};
    static int[] dy = {1, -1, 0, 0};
    static final int INF = Integer.MAX_VALUE;

    static class Node implements Comparable<Node> {
        int x;
        int y;
        int cost;

        public Node(int x, int y, int cost) {
            this.x = x;
            this.y = y;
            this.cost = cost;
        }

        @Override
        public int compareTo(Node other) {
            return this.cost - other.cost;
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        m = sc.nextInt();
        n = sc.nextInt();

        miro = new int[n][m];
        dist = new int[n][m];

        for (int i = 0; i < n; i++) {
            String line = sc.next();
            Arrays.fill(dist[i], INF);
            for (int j = 0; j < m; j++) {
                miro[i][j] = line.charAt(j) - '0';
            }
        }

        dijkstra();

        System.out.println(dist[n - 1][m - 1]);
    }

    static void dijkstra() {
        PriorityQueue<Node> pq = new PriorityQueue<>();

        dist[0][0] = 0;
        pq.add(new Node(0, 0, 0));

        while (!pq.isEmpty()) {
            Node nodes = pq.poll();

            if (nodes.cost > dist[nodes.x][nodes.y]) {
                continue;
            }

            for (int i = 0; i < 4; i++) {
                int nextX = nodes.x + dx[i];
                int nextY = nodes.y + dy[i];

                if (nextX < 0 || nextY < 0 || nextX >= n || nextY >= m) {
                    continue;
                }

                int newCost = dist[nodes.x][nodes.y] + miro[nextX][nextY];

                if (newCost < dist[nextX][nextY]) {
                    dist[nextX][nextY] = newCost;
                    pq.add(new Node(nextX, nextY, newCost));
                }
            }
        }
    }
}
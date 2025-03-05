package gold;

import java.util.*;

//우선순위 Queue
class Node implements Comparable<Node> {
    int vertex, weight;

    public Node(int vertex, int weight) {
        this.vertex = vertex; //현재노드
        this.weight = weight; //도달 비용
    }

    @Override
    public int compareTo(Node other) {
        return Integer.compare(this.weight, other.weight);
    }
}

public class BJ1238 {
    static final int INF = Integer.MAX_VALUE;
    static List<List<Node>> graph;
    static int N, M, X;

    public static int[] dijkstra(int start) {
        PriorityQueue<Node> pq = new PriorityQueue<>();
        int[] dist = new int[N + 1];
        Arrays.fill(dist, INF);
        dist[start] = 0;
        pq.offer(new Node(start, 0));

        while (!pq.isEmpty()) {
            Node current = pq.poll();
            int curVertex = current.vertex;
            int curWeight = current.weight;

            if (curWeight > dist[curVertex]) continue;

            for (Node neighbor : graph.get(curVertex)) {
                int newDist = curWeight + neighbor.weight;
                if (newDist < dist[neighbor.vertex]) {
                    dist[neighbor.vertex] = newDist;
                    pq.offer(new Node(neighbor.vertex, newDist));
                }
            }
        }

        return dist;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt(); //마을 개수
        M = sc.nextInt(); //도로 개수
        X = sc.nextInt(); //파티 여리는 마을 번호

        graph = new ArrayList<>();
        for (int i = 0; i <= N; i++) {
            graph.add(new ArrayList<>());
        }

        for (int i = 0; i < M; i++) {
            int from = sc.nextInt();
            int to = sc.nextInt();
            int weight = sc.nextInt();
            graph.get(from).add(new Node(to, weight));
        }

        int[] distToX = new int[N + 1];
        int[] distFromX = dijkstra(X);

        for (int i = 1; i <= N; i++) {
            distToX[i] = dijkstra(i)[X];
        }

        int maxTime = 0;
        for (int i = 1; i <= N; i++) {
            maxTime = Math.max(maxTime, distToX[i] + distFromX[i]);
        }

        System.out.println(maxTime);
    }
}

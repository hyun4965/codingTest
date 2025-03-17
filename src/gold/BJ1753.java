package gold;

import java.util.*;

public class BJ1753 {
    static class Node implements Comparable<Node> {
        int vertex, weight;

        Node(int vertex, int weight) {
            this.vertex = vertex;
            this.weight = weight;
        }

        @Override
        public int compareTo(Node o) {
            return Integer.compare(this.weight, o.weight);
        }
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int V = sc.nextInt(); //정점의 갯수
        int E = sc.nextInt(); //간선의 갯수

        int K = sc.nextInt(); //정점 시작 번호

        List<List<Node>> graph = new ArrayList<>();
        for (int i = 0; i <= V; i++) {
            graph.add(new ArrayList<>());
        }
        for (int i = 0; i < E; i++) {
            int u = sc.nextInt();
            int v = sc.nextInt();
            int w = sc.nextInt();
            graph.get(u).add(new Node(v, w));
        }

        dijkstra(V, graph, K);
    }
    public static void dijkstra(int V, List<List<Node>> graph, int start) {
        PriorityQueue<Node> pq = new PriorityQueue<>();
        int[] dist = new int[V + 1];

        Arrays.fill(dist, Integer.MAX_VALUE);
        dist[start] = 0;
        pq.add(new Node(start, 0));
        while (!pq.isEmpty()) {
            Node current = pq.poll();
            int u = current.vertex;

            if (current.weight > dist[u]) continue;

            for (Node neighbor : graph.get(u)) {
                int v = neighbor.vertex;
                int weight = neighbor.weight;
                if (dist[u] + weight < dist[v]) {
                    dist[v] = dist[u] + weight;
                    pq.add(new Node(v, dist[v]));
                }
            }
        }

        for (int i = 1; i <= V; i++) {
            System.out.println(dist[i] == Integer.MAX_VALUE ? "INF" : dist[i]);
        }
    }
}

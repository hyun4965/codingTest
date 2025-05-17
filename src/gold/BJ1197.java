package gold;

import java.util.*;

public class BJ1197 {
    static class Node implements Comparable<Node> {
        int to, weight;

        Node(int to, int weight) {
            this.to = to;
            this.weight = weight;
        }

        @Override
        public int compareTo(Node o) {
            return Integer.compare(this.weight, o.weight);
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int V = sc.nextInt(); // 정점 수
        int E = sc.nextInt(); // 간선 수

        List<List<Node>> graph = new ArrayList<>(); //인접 리스트
        for (int i = 0; i <= V; i++) {
            graph.add(new ArrayList<>());
        }

        for (int i = 0; i < E; i++) {
            int a = sc.nextInt();
            int b = sc.nextInt();
            int c = sc.nextInt();

            graph.get(a).add(new Node(b, c));
            graph.get(b).add(new Node(a, c));
        }

        boolean[] visited = new boolean[V + 1];
        PriorityQueue<Node> pq = new PriorityQueue<>();
        int totalWeight = 0;

        pq.add(new Node(1, 0));

        while (!pq.isEmpty()) {
            Node current = pq.poll();
            int to = current.to;
            int weight = current.weight;

            if (visited[to]) {
                continue;
            }

            visited[to] = true;
            totalWeight += weight;

            for (Node neighbor : graph.get(to)) {
                if (!visited[neighbor.to]) {
                    pq.add(neighbor);
                }
            }
        }

        System.out.println(totalWeight);
    }
}

package gold;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class BJ11779 {

    static final int INF = Integer.MAX_VALUE;
    static List<Node>[] graph;
    static int[] distance;
    static int[] parent; // 경로 추적을 위한 배열
    static int n, m;

    static class Node implements Comparable<Node> {
        int index;
        int weight;

        public Node(int index, int weight) {
            this.index = index;
            this.weight = weight;
        }

        @Override
        public int compareTo(Node n) {
            return this.weight - n.weight;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine()); // 도시의 개수
        m = Integer.parseInt(br.readLine()); // 버스의 개수

        graph = new ArrayList[n + 1];
        distance = new int[n + 1];
        parent = new int[n + 1];
        for (int i = 1; i <= n; i++) {
            graph[i] = new ArrayList<>();
        }

        Arrays.fill(distance, INF);

        for (int i = 0; i < m; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            int cost = Integer.parseInt(st.nextToken());
            graph[start].add(new Node(end, cost));
        }

        StringTokenizer st = new StringTokenizer(br.readLine());
        int startNode = Integer.parseInt(st.nextToken());
        int endNode = Integer.parseInt(st.nextToken());

        dijkstra(startNode);

        System.out.println(distance[endNode]);

        List<Integer> path = new ArrayList<>();
        int current = endNode;
        while (current != 0) {
            path.add(current);
            current = parent[current];
        }
        Collections.reverse(path);

        System.out.println(path.size());
        for (int node : path) {
            System.out.print(node + " ");
        }
        System.out.println();
    }

    static void dijkstra(int start) {
        PriorityQueue<Node> pq = new PriorityQueue<>();
        distance[start] = 0;
        parent[start] = 0;
        pq.offer(new Node(start, 0));

        while (!pq.isEmpty()) {
            Node currentNode = pq.poll();
            int u = currentNode.index;
            int w = currentNode.weight;

            if (w > distance[u]) {
                continue;
            }

            for (Node neighborNode : graph[u]) {
                int v = neighborNode.index;
                int weight = neighborNode.weight;

                if (distance[u] + weight < distance[v]) {
                    distance[v] = distance[u] + weight;
                    parent[v] = u;
                    pq.offer(new Node(v, distance[v]));
                }
            }
        }
    }
}


package news;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.Scanner;

public class BJ1753 {
    static int v,e,k;
    static ArrayList<ArrayList<Node>> graph;
    static int[] dist;

    static class Node implements Comparable<Node> {
        int index;
        int cost;

        public Node(int index, int cost) {
            this.index = index;
            this.cost = cost;
        }

        @Override
        public int compareTo(Node o) {
            return this.cost - o.cost;
        }
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        v=sc.nextInt();
        e=sc.nextInt();
        k = sc.nextInt();

        graph = new ArrayList<>();
        for (int i = 0; i <= v; i++) {
            graph.add(new ArrayList<>());
        }
        dist = new int[v+1];
        Arrays.fill(dist,Integer.MAX_VALUE);
        for(int i=0; i<e; i++) {
            int u = sc.nextInt();
            int v = sc.nextInt();
            int w = sc.nextInt();
            graph.get(u).add(new Node(v, w));
        }
        dijkstra(k);

        for (int i = 1; i <= v; i++) {
            if (dist[i] == Integer.MAX_VALUE) {
                System.out.println("INF");
            } else {
                System.out.println(dist[i]);
            }
        }
    }
    static void dijkstra(int start) {
        PriorityQueue<Node> pq = new PriorityQueue<>();

        dist[start] = 0;
        pq.offer(new Node(start, 0));

        while (!pq.isEmpty()) {
            Node current = pq.poll();
            int now = current.index;
            int nowCost = current.cost;

            if (nowCost > dist[now]) {
                continue;
            }

            for (Node next : graph.get(now)) {
                if (dist[now] + next.cost < dist[next.index]) {
                    dist[next.index] = dist[now] + next.cost;
                    pq.offer(new Node(next.index, dist[next.index]));
                }
            }
        }
    }
}

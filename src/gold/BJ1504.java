package gold;
//우선순위 Queue

import java.util.*;

//class Node implements Comparable<Node> {
//    int vertex, weight;
//
//    public Node(int vertex, int weight) {
//        this.vertex = vertex; // 현재 노드
//        this.weight = weight; // 도달 비용
//    }
//
//    @Override
//    public int compareTo(Node other) {
//        return Integer.compare(this.weight, other.weight);
//    }
//}

public class BJ1504 {
    static int N, E;
    static List<List<Node>> graph;
    static final int INF = Integer.MAX_VALUE;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        E = sc.nextInt();
        graph = new ArrayList<>();

        for (int i = 0; i <= N; i++) {
            graph.add(new ArrayList<>());
        }

        // 간선 입력 받기
        for (int i = 0; i < E; i++) {
            int a = sc.nextInt();
            int b = sc.nextInt();
            int c = sc.nextInt();
            graph.get(a).add(new Node(b, c)); //양방향
            graph.get(b).add(new Node(a, c)); //양방향
        }

        int v1 = sc.nextInt();
        int v2 = sc.nextInt();

        // 다익스트라 실행
        int[] distFrom1 = dijkstra(1);
        int[] distFromV1 = dijkstra(v1);
        int[] distFromV2 = dijkstra(v2);

        // 1 → v1 → v2 → N 경로
        long path1 = (long) distFrom1[v1] + distFromV1[v2] + distFromV2[N];

        // 1 → v2 → v1 → N 경로
        long path2 = (long) distFrom1[v2] + distFromV2[v1] + distFromV1[N];

        long result = Math.min(path1, path2);

        // 경로가 없을 경우 -1 출력
        System.out.println((result >= INF) ? -1 : result);
    }

    // 다익스트라 알고리즘 (최단 거리 구하기)
    static int[] dijkstra(int start) {
        PriorityQueue<Node> pq = new PriorityQueue<>();
        int[] dist = new int[N + 1];
        Arrays.fill(dist, INF);
        dist[start] = 0;
        pq.offer(new Node(start, 0));

        while (!pq.isEmpty()) {
            Node current = pq.poll();
            int curVertex = current.vertex;
            int curWeight = current.weight;

            if (curWeight > dist[curVertex]) {
                continue;
            }

            for (Node next : graph.get(curVertex)) {
                int newDist = dist[curVertex] + next.weight;
                if (newDist < dist[next.vertex]) {
                    dist[next.vertex] = newDist;
                    pq.offer(new Node(next.vertex, newDist));
                }
            }
        }
        return dist;
    }
}

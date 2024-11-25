package gold;

import java.io.*;
import java.util.*;

public class BJ1916 {
    //도시 , 비용 관련 Node 클래스 생성
    static class Node implements Comparable<Node> {
        int city, cost;
        public Node(int city, int cost) {
            this.city = city;
            this.cost = cost;
        }

        @Override
        public int compareTo(Node o) {
            return this.cost - o.cost;
        }
    }

    public static void main(String[] args) throws IOException {
        StringTokenizer st;
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int M = Integer.parseInt(br.readLine());

        //노드 입력 받기.
        List<List<Node>> graph = new ArrayList<>();
        for (int i = 0; i <= N; i++) {
            graph.add(new ArrayList<>());
        }
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int from = Integer.parseInt(st.nextToken());
            int to = Integer.parseInt(st.nextToken());
            int cost = Integer.parseInt(st.nextToken());
            graph.get(from).add(new Node(to, cost));
        }

        //시작과 끝 입력받기.
        st = new StringTokenizer(br.readLine());
        int start = Integer.parseInt(st.nextToken());
        int end = Integer.parseInt(st.nextToken());
        System.out.println(dijkstra(N,graph,start,end));

    }

    //다익스트라를 PriorityQueue 사용
    private static int dijkstra(int N, List<List<Node>> graph, int start, int end) {
        PriorityQueue<Node> pq = new PriorityQueue<>();
        int[] dist = new int[N + 1];
        Arrays.fill(dist, Integer.MAX_VALUE); //dist 배열 초기화.

        pq.offer(new Node(start, 0));
        dist[start] = 0;

        while (!pq.isEmpty()) {
            Node current = pq.poll();
            int currentCity = current.city;
            int currentCost = current.cost;

            if (currentCost > dist[currentCity]) {
                continue;
            }

            for (Node neighbor : graph.get(currentCity)) {
                int nextCity = neighbor.city;
                int nextCost = currentCost + neighbor.cost;

                if (nextCost < dist[nextCity]) {
                    dist[nextCity] = nextCost;
                    pq.offer(new Node(nextCity, nextCost));
                }
            }
        }
        return dist[end];
    }
}

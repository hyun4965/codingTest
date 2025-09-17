import java.util.*;

class Solution {
    class Node  {
        int e;  
        int cost; 
        
        Node(int e, int cost) {
            this.e = e;
            this.cost = cost;
        }
    }
    
    public int solution(int N, int[][] road, int K) {
        int answer = 0;
        
        List<List<Node>> graph = new ArrayList<>(N + 1);
        for(int i=0; i<=N; i++){
            graph.add(new ArrayList<>());
        }
        
        
        for (int[] r : road) {
            int a = r[0], b = r[1], c = r[2];
            graph.get(a).add(new Node(b, c));
            graph.get(b).add(new Node(a, c)); 
        }
        
        final int INF = 1_000_000_000;
        int[] dist = new int[N + 1];
        Arrays.fill(dist, INF);
        dist[1] = 0;

        PriorityQueue<Node> pq = new PriorityQueue<>(Comparator.comparingInt(n -> n.cost));
        pq.offer(new Node(1, 0));

        while (!pq.isEmpty()) {
            Node cur = pq.poll();
            int v = cur.e, d = cur.cost;

            if (d > dist[v]) {
                continue; 
            }
            for (Node nx : graph.get(v)) {
                int nd = d + nx.cost;
                if (nd < dist[nx.e]) {
                    dist[nx.e] = nd;
                    pq.offer(new Node(nx.e, nd));
                }
            }
        }

        for (int i = 1; i <= N; i++) {
            if (dist[i] <= K) {
                answer++;
            }
        }
        return answer;

    }
}
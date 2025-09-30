import java.util.*;

class Solution {
    public class Edge implements Comparable<Edge> {
        int to;
        int cost;

        public Edge(int to, int cost) {
            this.to = to;
            this.cost = cost;
        }

        @Override
        public int compareTo(Edge other) {
            return Integer.compare(this.cost, other.cost);
        }
    }

    public int solution(int n, int[][] costs) {
        int totalCost = 0; 
        
        List<List<Edge>> graph = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            graph.add(new ArrayList<>());
        }

        for (int[] edge : costs) {
            int from = edge[0];
            int to = edge[1];
            int cost = edge[2];
            graph.get(from).add(new Edge(to, cost));
            graph.get(to).add(new Edge(from, cost));
        }

        PriorityQueue<Edge> pq = new PriorityQueue<>();
        boolean[] visited = new boolean[n]; 

        visited[0] = true;
        pq.addAll(graph.get(0));

        int connectedCount = 1; 

        while (connectedCount < n) {
            if (pq.isEmpty()) {
                break;
            }

            Edge currentEdge = pq.poll();

            if (visited[currentEdge.to]) {
                continue;
            }

            visited[currentEdge.to] = true;
            totalCost += currentEdge.cost; 
            connectedCount++; 

            pq.addAll(graph.get(currentEdge.to));
        }

        return totalCost;
    }
}
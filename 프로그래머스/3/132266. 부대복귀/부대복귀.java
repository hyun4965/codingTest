import java.util.*;

class Solution {
    public int[] solution(int n, int[][] roads, int[] sources, int destination) {
        
        List<List<Integer>> graph = new ArrayList<>();
        
        for(int i=0; i <= n; i++){ 
            graph.add(new ArrayList<>());
        }
        
        for(int i=0; i<roads.length; i++){
            int from = roads[i][0];
            int to = roads[i][1];
            graph.get(from).add(to);
            graph.get(to).add(from);
        }
        
        int[] dist = new int[n + 1];
        Arrays.fill(dist, -1);

        Queue<Integer> q = new LinkedList<>();
        q.add(destination);
        dist[destination] = 0;

        while (!q.isEmpty()) {
            int cur = q.poll();

            for (int next : graph.get(cur)) {
                if (dist[next] == -1) {
                    dist[next] = dist[cur] + 1; 
                    q.add(next);
                }
            }
        }

        int[] answer = new int[sources.length];
        for (int i = 0; i < sources.length; i++) {
            answer[i] = dist[sources[i]];
        }

        return answer;
    }
}
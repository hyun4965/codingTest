import java.util.*;

class Solution {
    public int solution(int n, int[][] edge) {
        //양방향 그래프 생성
        List<List<Integer>> graph = new ArrayList<>();
        for (int i = 0; i <= n; i++) {
            graph.add(new ArrayList<>());
        }
        
        for (int[] e : edge) {
            int a = e[0];
            int b = e[1];
            graph.get(a).add(b);
            graph.get(b).add(a);
        }
        

        int[] distance = new int[n + 1];
        Arrays.fill(distance, -1);

        Queue<Integer> queue = new LinkedList<>();
        
        queue.add(1);
        distance[1] = 0; 
        
        int maxDistance = 0;

        while (!queue.isEmpty()) {
            int now = queue.poll();
            
            for (int neighbor : graph.get(now)) {
                if (distance[neighbor] == -1) {
                    distance[neighbor] = distance[now] + 1;
                    queue.add(neighbor);
                    maxDistance = Math.max(maxDistance, distance[neighbor]);
                }
            }
        }
        
        int answer = 0;
        for (int i = 1; i <= n; i++) {
            if (distance[i] == maxDistance) {
                answer++;
            }
        }
        
        return answer;
    }
}
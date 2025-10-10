import java.util.*;

class Solution {
    public int[] solution(int n, int[][] roads, int[] sources, int destination) {
        
        int[] answer = new int[sources.length];
        
        List<Integer>[] graph = new ArrayList[n+1];
        for(int i=0; i<=n;i++){
            graph[i] = new ArrayList<>();
        }
        
        for(int[] road : roads){
            graph[road[0]].add(road[1]);
            graph[road[1]].add(road[0]);
        }
        
        int[] distances = new int[n + 1];
        Arrays.fill(distances, -1);
        
        Queue<Integer> queue = new LinkedList<>();
        queue.offer(destination);
        distances[destination] = 0;
        
        while(!queue.isEmpty()){
            int now = queue.poll();
            
            for(int next : graph[now]){
                if(distances[next] == -1){
                    distances[next] = distances[now] + 1;
                    queue.offer(next);
                }
            }
        }
        
        
        
        for (int i = 0; i < sources.length; i++) {
            answer[i] = distances[sources[i]];
        }
        return answer;
    }
}
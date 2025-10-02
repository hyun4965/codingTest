import java.util.*;

class Solution {
    public static List<List<Integer>> graph;
    public int solution(int n, int[][] edge) {
        
        List<List<Integer>> graph = new ArrayList<>();
        for (int i = 0; i <= n; i++) {
            graph.add(new ArrayList<>());
        }

        for (int[] e : edge) {
            int from = e[0];
            int to = e[1];
            graph.get(from).add(to);
            graph.get(to).add(from);
        }
        boolean[] visited = new boolean[n+1];
        return bfs(graph,n,visited);
    
    }
    static public int bfs(List<List<Integer>> graph, int n, boolean[] visited){
        int answer = 0;
        Queue<int[]> que = new LinkedList<>();
        que.add(new int[]{1,0});
        visited[1] = true;
        int maxDepth=0;
        while(!que.isEmpty()){
            int[] arr = que.poll();
            int v = arr[0];
            int depth = arr[1];
            
            if(depth == maxDepth){
                answer ++;
            }else if(maxDepth < depth){
                answer = 1;
                maxDepth = depth;
            }
            for(int i=0; i<graph.get(v).size();i++){
                int w = graph.get(v).get(i);
                if(!visited[w]){
                    que.add(new int[]{w,depth+1});
                    visited[w]= true;
                }
            }
        }
        return answer;
    }

}
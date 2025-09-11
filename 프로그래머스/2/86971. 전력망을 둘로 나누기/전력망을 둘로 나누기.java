import java.util.*;

class Solution {
    List<Integer>[] graph;   
    int[] size;        
    boolean[] visited;
    int n;

    public int solution(int n, int[][] wires) {
        this.n = n;
        graph = new ArrayList[n + 1];
        for (int i = 1; i <= n; i++) {
            graph[i] = new ArrayList<>();
        }
        
        for (int[] w : wires) {
            int a = w[0];
            int b = w[1];
            graph[a].add(b);
            graph[b].add(a);
        }

        size = new int[n + 1];
        visited = new boolean[n + 1];

        dfs(1, 0);


        int answer = Integer.MAX_VALUE;
        for (int v = 2; v <= n; v++) { 
            int diff = Math.abs(n - 2 * size[v]);
            answer = Math.min(answer, diff);
        }

        return answer;
    }

    private void dfs(int u, int parent) {
        visited[u] = true;
        size[u] = 1;
        for (int v : graph[u]) {
            if (v == parent) {
                continue;     
            }
            dfs(v, u);
            size[u] += size[v];
        }
    }
}

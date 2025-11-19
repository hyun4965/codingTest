import java.util.*;

class Solution {
    private int[] parent;

    public int solution(int n, int[][] costs) {
        int answer = 0;
        
        Arrays.sort(costs, (a, b) -> a[2] - b[2]);
        
        parent = new int[n];
        for (int i = 0; i < n; i++) {
            parent[i] = i;
        }
        
        for (int[] edge : costs) {
            int from = edge[0];
            int to = edge[1];
            int cost = edge[2];
            
            if (find(from) != find(to)) {
                union(from, to);
                answer += cost;
            }
        }
        
        return answer;
    }
    
    private int find(int node) {
        if (parent[node] == node) {
            return node;
        }
        return parent[node] = find(parent[node]);
    }
    
    private void union(int node1, int node2) {
        int root1 = find(node1);
        int root2 = find(node2);
        
        if (root1 < root2) {
            parent[root2] = root1;
        } else {
            parent[root1] = root2;
        }
    }
}
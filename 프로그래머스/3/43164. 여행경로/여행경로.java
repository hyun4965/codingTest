import java.util.*;
class Solution {
    
    Map<String, PriorityQueue<String>> graph = new HashMap<>();
    LinkedList<String> route = new LinkedList<>();
    
    public String[] solution(String[][] tickets) {
        for (String[] ticket : tickets) {
            String from = ticket[0];
            String to = ticket[1];
            graph.putIfAbsent(from, new PriorityQueue<>());
            graph.get(from).add(to);
        }

        dfs("ICN");

        return route.toArray(new String[0]);
    } 
    
    private void dfs(String airport) {
        // key 값은 있으면서, 비어있지 않으면 연결
        while (graph.containsKey(airport) && !graph.get(airport).isEmpty()) {
            String next = graph.get(airport).poll();
            dfs(next);
            
        }
        
        route.addFirst(airport);
    }
}
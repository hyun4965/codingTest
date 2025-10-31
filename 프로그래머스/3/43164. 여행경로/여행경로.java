import java.util.*;

class Solution {

    static List<String> list = new ArrayList<>();
    static boolean[] visited;
    static boolean isSuccess = false; 

    public String[] solution(String[][] tickets) {
        
        visited = new boolean[tickets.length]; 
        
        Arrays.sort(tickets, (a, b) -> {
            if (a[0].equals(b[0])) {
                return a[1].compareTo(b[1]);
            }
            return a[0].compareTo(b[0]);
        });
        
        dfs("ICN", tickets);
        
        return list.toArray(new String[0]);
    }

    static void dfs(String now, String[][] tickets) {
        list.add(now);
        
        if (list.size() == tickets.length + 1) {
            isSuccess = true;
            return;
        }
        
        for (int i = 0; i < tickets.length; i++) {
            if (!visited[i] && tickets[i][0].equals(now)) {
                
                visited[i] = true; 
                dfs(tickets[i][1], tickets); 
                
                if (isSuccess) {
                    return;
                }
                
                visited[i] = false; 
            }
        }

        if (!isSuccess) {
            list.remove(list.size() - 1);
        }
    }
}
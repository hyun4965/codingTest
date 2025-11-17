import java.util.*;

class Solution {
    String[] users;
    String[] bans;
    boolean[] visited;
    Set<Integer> resultSet = new HashSet<>();

    public int solution(String[] user_id, String[] banned_id) {
        this.users = user_id;
        this.bans = banned_id;
        this.visited = new boolean[user_id.length];

        dfs(0, 0);
        return resultSet.size();
    }

    private void dfs(int depth, int mask) {
        if (depth == bans.length) {
            resultSet.add(mask);  
            return;
        }

        for (int i = 0; i < users.length; i++) {
            if (visited[i]) continue;
            if (!isMatch(users[i], bans[depth])) continue; 

            visited[i] = true;
            dfs(depth + 1, mask | (1 << i)); 
            visited[i] = false; 
        }
    }

    private boolean isMatch(String user, String ban) {
        if (user.length() != ban.length()) return false;

        for (int i = 0; i < user.length(); i++) {
            char uc = user.charAt(i);
            char bc = ban.charAt(i);
            if (bc == '*') continue;
            if (uc != bc) return false;
        }
        return true;
    }
}

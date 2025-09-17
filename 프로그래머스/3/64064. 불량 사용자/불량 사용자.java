import java.util.*;

class Solution {
    
    static int cnt = 0;
    static boolean[] visited;
    static String[] result;
    static List<String[]> visit = new ArrayList<>();
    
    public int solution(String[] user_id, String[] banned_id) {
        
        visited = new boolean[user_id.length];
        result = new String[banned_id.length];
        dfs(0,0,user_id,banned_id);
        return cnt;
    }

    public static void dfs(int start, int depth, String[] user, String[] ban){
        if(depth == ban.length){
            int a = 0;
            for (String[] strings : visit) {
                for (String r : result) {
                    for (String s : strings) {
                        if(r.equals(s)){
                            a++;
                        }
                    }
                }
                if(a == ban.length){
                    return;
                }
                a = 0;
            }
            String[] m = new String[result.length];
            for(int i=0;i<result.length;i++){
                m[i] = result[i];
            }
            visit.add(m);
            cnt++;
            return;
        }

        for(int i = start; i<ban.length; i++){
            for(int j = 0;j<user.length;j++){
                if(!visited[j]){
                    char[] b = ban[i].toCharArray();
                    char[] u = user[j].toCharArray();
                    if(b.length == u.length){
                        int flag = 1;
                        for(int k=0;k<b.length;k++){
                            if(b[k] != '*'){
                                if(b[k] != u[k]){
                                    flag = 0;
                                    break;
                                }
                            }
                        }
                        if(flag == 0){
                            continue;
                        }
                        visited[j] = true;
                        result[depth] = user[j];
                        dfs(i+1, depth+1, user, ban);
                        visited[j] = false;
                    }
                }
            }
        }
    }
}
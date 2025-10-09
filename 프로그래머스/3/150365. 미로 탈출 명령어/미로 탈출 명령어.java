class Solution {
    static int N,M;
    static int startX,startY;
    static int endX, endY;
    static int maxMove;
    static String answer = null;
    
    static int[] dx = {1, 0, 0, -1};
    static int[] dy = {0, -1, 1, 0};
    static String[] dir = {"d", "l", "r", "u"};
    
    public String solution(int n, int m, int x, int y, int r, int c, int k) {

        N = n; M = m;
        startX = x; startY = y;
        endX = r; endY = c;
        maxMove = k;
        
        int dist = Math.abs(startX-endX) + Math.abs(startY - endY);
        if(dist > k){
            return "impossible";
        }
        if(dist % 2 != k % 2){
            return "impossible";
        }
        
        dfs(startX,startY,new StringBuilder());
        return answer == null ? "impossible" : answer;
        
    }
    private static void dfs(int x, int y, StringBuilder path){
        if(answer != null){
            return;
        }
        
        if(path.length() == maxMove){
            if(x==endX && y == endY){
                answer = path.toString();
            }
            return;
        }
        int dist = Math.abs(endX - x) + Math.abs(endY - y);
        
        if (maxMove - path.length() < dist) {
            return;
        }

        for (int i = 0; i < 4; i++) {
            int nx = x + dx[i];
            int ny = y + dy[i];

            if (nx < 1 || nx > N || ny < 1 || ny > M) {
                continue;
            }

            path.append(dir[i]);
            dfs(nx, ny, path);
            path.deleteCharAt(path.length() - 1); 
        }
    }
}
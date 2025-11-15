import java.util.*;
class Solution {
    static int n, m;
    static String[] maps;
    static int[] dx = {-1, 0, 1, 0};
    static int[] dy = {0, -1, 0, 1};
    
    public int solution(String[] maps) {
        this.maps = maps;
        n = maps.length;
        m = maps[0].length();
        int sx = -1, sy = -1;
        int lx = -1, ly = -1;
        int ex = -1, ey = -1;
        
        for(int i=0; i<n; i++){
            for(int j=0; j<m; j++){
                char c = maps[i].charAt(j);
                if(c=='S'){
                    sx = i; sy = j;
                }else if (c == 'L') { 
                    lx = i; ly = j; 
                }else if (c == 'E') {
                    ex = i; ey = j; 
                }
            }
        }
        int distSL = bfs(sx,sy,lx,ly);
        if(distSL == -1){
            return -1;
        }
        int distLE = bfs(lx,ly,ex,ey);
        if(distLE== -1){
            return -1;
        }
        return distSL + distLE;
    }
    public static int bfs(int sx, int sy, int tx, int ty){
        Queue<int[]> q = new LinkedList<>();
        int[][] dist = new int[n][m];
        for(int i=0; i<n; i++){
            Arrays.fill(dist[i], -1);
        }
        q.offer(new int[]{sx,sy});
        dist[sx][sy] = 0;
        while(!q.isEmpty()){
            int[] cur = q.poll();
            int x = cur[0];
            int y = cur[1];
            if (x == tx && y == ty) {
                return dist[x][y];
            }
            
            for(int i=0; i<4; i++){
                int nx = x + dx[i];
                int ny = y + dy[i];
                if (nx < 0 || ny < 0 || nx >= n || ny >= m) continue;
                char c = maps[nx].charAt(ny);
                if (c == 'X') continue;
                if (dist[nx][ny] != -1) continue;
                
                dist[nx][ny] = dist[x][y] + 1;
                q.offer(new int[]{nx, ny});

            }
        }
        return -1;
    }
}
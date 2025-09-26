import java.util.*;

class Solution {
    static final int[] dx = {-1, 1, 0, 0};
    static final int[] dy = {0, 0, -1, 1};
    
    static int n, m;
    static char[][] map;
    static boolean[][] visited;
    
    public int solution(String[] board) {
        n = board.length;
        m = board[0].length();
        map = new char[n][m];
        visited = new boolean[n][m];

        int sx = -1, sy = -1, gx = -1, gy = -1;
        for (int i = 0; i < n; i++) {
            map[i] = board[i].toCharArray();
            for (int j = 0; j < m; j++) {
                if (map[i][j] == 'R') { sx = i; sy = j; }
                if (map[i][j] == 'G') { gx = i; gy = j; }
            }
        }
        Queue<int[]> q = new ArrayDeque<>();
        q.offer(new int[]{sx, sy, 0}); 
        visited[sx][sy] = true;    
        while(!q.isEmpty()){
            int[] current = q.poll();
            int cx = current[0];
            int cy = current[1];
            int count = current[2];
            
            if(cx == gx && cy == gy){
                return count;
            }
            
            for(int i=0; i<4; i++){
                int nx = cx;
                int ny = cy;
                while(true){
                    int nextX = nx + dx[i];
                    int nextY = ny + dy[i];
                    if (nextX < 0 || nextX >= n || nextY < 0 || nextY >= m || map[nextX][nextY] == 'D') {
                        break;
                    }
                    nx = nextX;
                    ny = nextY;
                }
                if (!visited[nx][ny]) {
                    visited[nx][ny] = true; 
                    q.offer(new int[]{nx, ny, count + 1});
                }
            }
            
        }
    
    
    return -1;
    }
}
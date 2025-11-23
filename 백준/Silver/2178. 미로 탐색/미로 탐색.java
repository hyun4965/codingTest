import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main {
    static int n,m;
    static int[][] miro;
    static boolean[][] visited;
    static int[] dx = {1,-1,0,0};
    static int[] dy = {0,0,-1,1};
    
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        m = sc.nextInt();

        miro = new int[n][m];
        visited = new boolean[n][m];
        for (int i = 0; i < n; i++) {
            String line = sc.next();
            for (int j = 0; j < m; j++) {
                miro[i][j] = line.charAt(j) - '0';
            }
        }
        bfs(0,0);
        System.out.println(miro[n - 1][m - 1]);
    }
    static void bfs(int i, int j) {
        Queue<int[]> q = new LinkedList<>();
        visited[i][j] = true;
        q.add(new int[]{i,j});
        while (!q.isEmpty()) {
            int[] cur = q.poll();
            int cx = cur[0];
            int cy = cur[1];
            for(int k=0; k<4; k++){
                int nx = cx + dx[k];
                int ny = cy + dy[k];
                if (nx >= 0 && ny >= 0 && nx < n && ny < m && !visited[nx][ny] && miro[nx][ny] == 1) {
                    q.offer(new int[]{nx, ny});
                    visited[nx][ny] = true;
                    miro[nx][ny] = miro[cx][cy] + 1;
                }
            }
        }
    }
}

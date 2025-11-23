package news;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class BJ1012 {
    static int m,n,k;
    static int[][] arr;
    static boolean[][] visited;
    static int[] dx ={-1,1,0,0};
    static int[] dy ={0,0,-1,1};
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while(t-->0){
            m =sc.nextInt();
            n =sc.nextInt();
            k =sc.nextInt();
            arr = new int[n][m];
            visited = new boolean[n][m];
            for(int i=0; i<k; i++){
                int x = sc.nextInt();
                int y = sc.nextInt();
                arr[y][x]=1;
            }
            int count =0;
            for(int i=0; i<n; i++){
                for(int j=0; j<m; j++){
                    if(arr[i][j]==1 && !visited[i][j]){
                        bfs(j,i);
                        count++;
                    }
                }
            }
            System.out.println(count);
        }
    }
    static void bfs(int x,int y){
        Queue<int[]> q = new LinkedList<>();
        q.add(new int[]{x,y});
        visited[y][x] = true;

        while(!q.isEmpty()){
            int[] cur = q.poll();
            int cx = cur[0],cy = cur[1];

            for(int i=0; i<4; i++){
                int nx = cx+dx[i],ny = cy+dy[i];
                if (nx >= 0 && ny >= 0 && nx < m && ny < n) {
                    if (arr[ny][nx] == 1 && !visited[ny][nx]) {
                        q.add(new int[]{nx, ny});
                        visited[ny][nx] = true;
                    }
                }
            }
        }

    }
}

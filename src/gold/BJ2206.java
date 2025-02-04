package gold;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class BJ2206 {
    static int[] dx = {-1,1,0,0};
    static int[] dy = {0,0,-1,1};
    static int[][] map;
    static int N,M;
    //0 : 이동 O
    //1 : 이동 X
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt(); // 행
        M = sc.nextInt(); // 열
        map = new int[N][M];

        for (int i = 0; i < N; i++) {
            String line = sc.next();
            for (int j = 0; j < M; j++) {
                map[i][j] = line.charAt(j) - '0';
            }
        }

        System.out.println(bfs());
    }

    public static int bfs() {
        Queue<int[]> queue = new LinkedList<>();
        boolean[][][] visited = new boolean[N][M][2];

        queue.add(new int[]{0,0,0,1});
        visited[0][0][0] = true;

        while (!queue.isEmpty()) {
            int[] current = queue.poll();
            int y = current[0];
            int x = current[1];
            int broken =current[2];
            int distance = current[3];
            //종료조건
            if( y == N -1 && x ==M -1){
                return distance;
            }
            for(int i=0; i<4; i++){
                int nx = x+dx[i];
                int ny = y+dy[i];

                if(nx >= 0 && nx < M && ny >= 0 && ny < N){
                    //벽 X
                    if (map[ny][nx] == 0 && !visited[ny][nx][broken]) {
                        visited[ny][nx][broken] = true;
                        queue.add(new int[]{ny, nx, broken, distance + 1});
                    }
                    //벽 O && 벽 부수기 남아 있는 경우
                    if (map[ny][nx] == 1 && broken == 0 && !visited[ny][nx][1]) {
                        visited[ny][nx][1] = true;
                        queue.add(new int[]{ny, nx, 1, distance + 1});
                    }
                }

            }

        }



        return -1; // 도착 불가능
    }
}

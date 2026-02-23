package gold;

import java.util.*;
import java.io.*;

public class BJ1600 {

    static int W, H, K;
    static int[][] map;
    static boolean[][][] isVisited;
    static int[][][] dist;

    static int[] dx = {0, 0, 1, -1, -1, -2, -2, -1, 1, 2, 2, 1};
    static int[] dy = {1, -1, 0, 0, -2, -1, 1, 2, 2, 1, -1, -2};

    static class Pos{
        int x, y;
        int hCnt;

        Pos(int x, int y, int hCnt){
            this.x = x;
            this.y = y;
            this.hCnt = hCnt;
        }
    }

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        K = Integer.parseInt(br.readLine());

        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        W = Integer.parseInt(st.nextToken());
        H = Integer.parseInt(st.nextToken());

        map = new int[H][W];
        isVisited = new boolean[H][W][K+1];
        dist = new int[H][W][K+1];

        for(int i=0; i<H; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            for(int j=0; j<W; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        int answer = bfs(0, 0);
        System.out.println(answer);
    }

    static int bfs(int x, int y) {
        Queue<Pos> queue = new LinkedList<>();

        queue.add(new Pos(x, y, 0));
        isVisited[x][y][0] = true;

        while(!queue.isEmpty()) {
            Pos p = queue.poll();
            int curX = p.x;
            int curY = p.y;
            int curH = p.hCnt;

            if(curX == H-1 && curY == W-1) {
                return dist[curX][curY][curH];
            }

            for(int t=0; t<4; t++) {
                int nx = curX + dx[t];
                int ny = curY + dy[t];

                if(nx < 0 || ny < 0 || nx >= H || ny >= W) continue;
                if(map[nx][ny] == 1) continue;
                if(isVisited[nx][ny][curH]) continue;

                isVisited[nx][ny][curH] = true;
                dist[nx][ny][curH] = dist[curX][curY][curH] + 1;
                queue.add(new Pos(nx, ny, curH));
            }

            if(curH < K) {
                for(int t=4; t<12; t++) {
                    int nx = curX + dx[t];
                    int ny = curY + dy[t];
                    int nextH = curH + 1;

                    if(nx < 0 || ny < 0 || nx >= H || ny >= W) continue;
                    if(map[nx][ny] == 1) continue;
                    if(isVisited[nx][ny][nextH]) continue;

                    isVisited[nx][ny][nextH] = true;
                    dist[nx][ny][nextH] = dist[curX][curY][curH] + 1;
                    queue.add(new Pos(nx, ny, nextH));
                }
            }
        }

        return -1;
    }
}
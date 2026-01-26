package gold;

import java.util.*;

public class BJ4179 {
    static int R, C;
    static char[][] map; // 메모리와 속도를 위해 char 배열 추천
    static int[][] fireTime; // 불이 번지는 시간 저장
    static int[][] moveTime; // 지훈이 이동 시간 저장
    static int[] dx = {1, 0, -1, 0};
    static int[] dy = {0, 1, 0, -1};


    static class Point {
        int x, y;
        Point(int x, int y){
            this.x = x;
            this.y = y;
        }
    }


    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        R = sc.nextInt();
        C = sc.nextInt();

        map = new char[R][C];
        fireTime = new int[R][C];
        moveTime = new int[R][C];

        Queue<Point> fire = new LinkedList<>();
        Queue<Point> move = new LinkedList<>();

        for(int i=0; i<R; i++){
            String s = sc.next();
            for(int j=0; j<C; j++){
                map[i][j] = s.charAt(j);
                fireTime[i][j] = -1;
                moveTime[i][j] = -1;

                if(map[i][j] == 'F'){
                    fire.offer(new Point(i, j));
                    fireTime[i][j] = 0;
                }
                if(map[i][j] == 'J'){
                    move.offer(new Point(i, j));
                    moveTime[i][j] = 0;
                }
            }
        }

        while(!fire.isEmpty()){
            Point cur = fire.poll();

            for(int i=0; i<4; i++){
                int nx = cur.x + dx[i];
                int ny = cur.y + dy[i];

                if(nx < 0 || nx >= R || ny < 0 || ny >= C) {
                    continue;
                }
                if(fireTime[nx][ny] >= 0 || map[nx][ny] == '#') {
                    continue;
                }

                fireTime[nx][ny] = fireTime[cur.x][cur.y] + 1;
                fire.offer(new Point(nx, ny));
            }
        }

        while(!move.isEmpty()){
            Point cur = move.poll();

            if(cur.x == 0 || cur.x == R-1 || cur.y == 0 || cur.y == C-1){
                System.out.println(moveTime[cur.x][cur.y] + 1);
                return;
            }

            for(int i=0; i<4; i++){
                int nx = cur.x + dx[i];
                int ny = cur.y + dy[i];

                if(nx < 0 || nx >= R || ny < 0 || ny >= C) {
                    continue;
                }
                if(moveTime[nx][ny] >= 0 || map[nx][ny] == '#') {
                    continue;
                }

                if(fireTime[nx][ny] != -1 && fireTime[nx][ny] <= moveTime[cur.x][cur.y] + 1){
                    continue;
                }

                moveTime[nx][ny] = moveTime[cur.x][cur.y] + 1;
                move.offer(new Point(nx, ny));
            }
        }

        System.out.println("IMPOSSIBLE");
    }
}
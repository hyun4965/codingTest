package gold;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class BJ9205 {
    static int t, n;
    static Info[] map;
    static boolean[] visit;

    static int startX, startY;
    static int destX, destY;

    static class Info{
        int x;
        int y;
        int remain;
        public Info(int x, int y, int remain){
            this.x = x;
            this.y = y;
            this.remain = remain;
        }
        public Info(int x, int y){
            this.x = x;
            this.y = y;
        }
    }
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] s;

        t = Integer.parseInt(br.readLine());

        for (int test = 0; test < t; test++) {

            n = Integer.parseInt(br.readLine());
            map = new Info[n];
            visit = new boolean[n];

            s = br.readLine().split(" ");
            startX = Integer.parseInt(s[0]);
            startY = Integer.parseInt(s[1]);

            for (int i = 0; i < n; i++) {
                int x, y;
                s = br.readLine().split(" ");

                x = Integer.parseInt(s[0]);
                y = Integer.parseInt(s[1]);

                map[i] = new Info(x, y);
            }

            s = br.readLine().split(" ");
            destX = Integer.parseInt(s[0]);
            destY = Integer.parseInt(s[1]);

            if(BFS())
                System.out.println("happy");
            else
                System.out.println("sad");
        }

    }

    private static boolean BFS() {
        Queue<Info> queue = new LinkedList<>();
        queue.add(new Info(startX, startY, 20));

        while (!queue.isEmpty()) {
            Info cur = queue.poll();

            if( ( Math.abs(cur.x - destX) + Math.abs(cur.y - destY) ) <= 50 * cur.remain) {
                return true;
            }

            for (int i = 0; i < n; i++) {

                if (visit[i]) continue;

                int x = map[i].x;
                int y = map[i].y;

                int diff = Math.abs(cur.x - x) + Math.abs(cur.y - y);

                if ( diff <= 50 * cur.remain ) {
                    visit[i] = true;
                    queue.add(new Info(x, y, 20));
                }

            }

        }

        return false;
    }

}

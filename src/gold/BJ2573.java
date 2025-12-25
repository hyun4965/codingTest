package gold;

import java.io.*;
import java.util.*;

public class BJ2573 {
    static class Iceberg {
        int x, y;

        public Iceberg(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    static int N, M;
    static int[][] map;
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};
    static List<Iceberg> iceList = new ArrayList<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        map = new int[N][M];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
                if (map[i][j] > 0) {
                    iceList.add(new Iceberg(i, j));
                }
            }
        }

        int year = 0;

        while (!iceList.isEmpty()) {
            int[] meltAmount = new int[iceList.size()];
            for (int i = 0; i < iceList.size(); i++) {
                Iceberg ice = iceList.get(i);
                int count = 0;

                for (int d = 0; d < 4; d++) {
                    int nx = ice.x + dx[d];
                    int ny = ice.y + dy[d];

                    if (map[nx][ny] == 0) {
                        count++;
                    }
                }
                meltAmount[i] = count;
            }


            int size = iceList.size();
            List<Iceberg> nextIceList = new ArrayList<>();

            for (int i = 0; i < size; i++) {
                Iceberg ice = iceList.get(i);
                map[ice.x][ice.y] -= meltAmount[i];

                if (map[ice.x][ice.y] > 0) {
                    nextIceList.add(ice);
                } else {
                    map[ice.x][ice.y] = 0;
                }
            }

            iceList = nextIceList;
            year++;

            if (iceList.size() == 0) {
                System.out.println(0);
                return;
            }

            if (checkSplit()) {
                System.out.println(year);
                return;
            }
        }

        System.out.println(0);
    }

    static boolean checkSplit() {
        if (iceList.isEmpty()) {
            return false;
        }

        int connectedCount = bfs(iceList.get(0));

        return connectedCount != iceList.size();
    }

    static int bfs(Iceberg start) {
        Queue<Iceberg> q = new LinkedList<>();
        boolean[][] visited = new boolean[N][M];

        q.add(start);
        visited[start.x][start.y] = true;
        int count = 1;

        while (!q.isEmpty()) {
            Iceberg cur = q.poll();

            for (int d = 0; d < 4; d++) {
                int nx = cur.x + dx[d];
                int ny = cur.y + dy[d];

                if (nx >= 0 && nx < N && ny >= 0 && ny < M) {
                    if (map[nx][ny] > 0 && !visited[nx][ny]) {
                        visited[nx][ny] = true;
                        q.add(new Iceberg(nx, ny));
                        count++;
                    }
                }
            }
        }
        return count;
    }
}
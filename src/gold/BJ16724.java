package gold;

import java.io.*;
import java.util.*;

public class BJ16724 {

    static int N, M;
    static char[][] map;
    static int[][] visited;
    // 0 = 방문 안함
    // 1 = 방문 중
    // 2 = 방문 완료

    static int answer = 0;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        map = new char[N][M];
        visited = new int[N][M];

        for (int i = 0; i < N; i++) {
            String line = br.readLine();
            for (int j = 0; j < M; j++) {
                map[i][j] = line.charAt(j);
            }
        }

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (visited[i][j] == 0) {
                    dfs(i, j);
                }
            }
        }

        System.out.print(answer);
    }

    static void dfs(int x, int y) {

        //방문중
        visited[x][y] = 1;

        int[] next = getNext(x, y);

        int nx = next[0];
        int ny = next[1];

        //방문 없다면 방문
        if (visited[nx][ny] == 0) {
            dfs(nx, ny);
        } else if (visited[nx][ny] == 1) {
            answer++;
        }
        //방문 완료
        visited[x][y] = 2;
    }

    static int[] getNext(int x, int y) {

        char dir = map[x][y];

        int nx = x;
        int ny = y;

        if (dir == 'U') {
            nx--;
        } else if (dir == 'D') {
            nx++;
        } else if (dir == 'L') {
            ny--;
        } else if (dir == 'R') {
            ny++;
        }

        return new int[]{nx, ny};
    }
}
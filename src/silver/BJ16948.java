package silver;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class BJ16948 {
    static int[] dx = {-2, -2, 0, 0, 2, 2};
    static int[] dy = {-1, 1, -2, 2, -1, 1};

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt(); // 체스판 크기
        int r1 = sc.nextInt();
        int c1 = sc.nextInt();
        int r2 = sc.nextInt();
        int c2 = sc.nextInt();

        System.out.println(bfs(N, r1, c1, r2, c2));
    }

    public static int bfs(int N, int r1, int c1, int r2, int c2) {
        boolean[][] visited = new boolean[N][N];
        Queue<int[]> queue = new LinkedList<>();

        queue.add(new int[]{r1, c1, 0}); // {현재 x, 현재 y, 이동 횟수}
        visited[r1][c1] = true;

        while (!queue.isEmpty()) {
            int[] current = queue.poll();
            int x = current[0]; //x 좌표
            int y = current[1]; //y 좌표
            int moves = current[2]; // 이동 횟수

            // 목표 지점에 도달한 경우
            if (x == r2 && y == c2) {
                return moves;
            }

            // 데스 나이트의 가능한 이동
            for (int i = 0; i < 6; i++) {
                int nx = x + dx[i];
                int ny = y + dy[i];

                // 6가지 넣어보고, 방문하지 않은 곳 방문
                if (nx >= 0 && nx < N && ny >= 0 && ny < N && !visited[nx][ny]) {
                    visited[nx][ny] = true;
                    queue.add(new int[]{nx, ny, moves + 1});
                }
            }
        }
        return -1;
    }
}
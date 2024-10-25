package silver;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class BJ2178 {
    static int[][] arr; // 미로 배열
    static boolean[][] visited; // 방문 여부 배열
    static int N, M; // 미로의 크기
    static int[] dx = { -1, 1, 0, 0 }; // 상, 하, 좌, 우 이동을 위한 배열
    static int[] dy = { 0, 0, -1, 1 };

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // N,M값 입력받기
        N = sc.nextInt();
        M = sc.nextInt();

        // 배열 입력받기
        arr = new int[N][M];
        visited = new boolean[N][M];

        //입력하기
        for (int i = 0; i < N; i++) {
            String input = sc.next();
            for (int j = 0; j < M; j++) {
                arr[i][j] = input.charAt(j) - '0'; //문자를 숫자로 변환해서 넣기
            }
        }

        //(0,0) 시작으로 최단거리 구하기
        System.out.println(bfs(0, 0));
    }

    public static int bfs(int x, int y) {
        Queue<int[]> queue = new LinkedList<>();
        queue.offer(new int[] { x, y });//시작점
        visited[x][y] = true;//시작 방문 처리기능

        while (!queue.isEmpty()) {
            int[] current = queue.poll();//현재 좌표 꺼내기

            int cx = current[0];
            int cy = current[1];

            //끝나면 반환하기.
            if (cx == N - 1 && cy == M - 1) {
                return arr[cx][cy];
            }

            // 상하좌우로 이동할 수 있는 모든 방향을 탐색
            for (int i = 0; i < 4; i++) {
                int nx = cx + dx[i];
                int ny = cy + dy[i];

                //미로 범위내에 이동할 수 있는곳
                if (nx >= 0 && ny >= 0 && nx < N && ny < M && arr[nx][ny] == 1 && !visited[nx][ny]) {
                    visited[nx][ny] = true;
                    arr[nx][ny] = arr[cx][cy] + 1;
                    queue.offer(new int[] { nx, ny });
                }
            }
        }

        return -1;
    }
}

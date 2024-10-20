package silver;

import java.util.*;

public class BJ1012 {
    static int[][] field; // 배추밭
    static boolean[][] visited; // 방문 여부를 체크할 배열
    static int M, N; // 배추밭의 가로, 세로 길이

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt(); // 테스트 케이스의 개수

        for (int t = 0; t < T; t++) {
            M = sc.nextInt(); //가로
            N = sc.nextInt(); //세로
            int K = sc.nextInt(); //배추 심어진 개수

            // 배추밭 초기화
            field = new int[N][M];
            visited = new boolean[N][M];

            // 배추 위치 입력 받기
            for (int i = 0; i < K; i++) {
                int x = sc.nextInt(); // x 좌표
                int y = sc.nextInt(); // y 좌표
                field[y][x] = 1; // 배추가 심어져 있는 곳을 1로 표시
            }

            int count = 0; // 필요한 배추흰지렁이의 수

            // 모든 배추를 탐색
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < M; j++) {
                    if (field[i][j] == 1 && !visited[i][j]) {
                        bfs(i, j);
                        count++;
                    }
                }
            }

            System.out.println(count);
        }
    }

    public static void bfs(int startY, int startX) {
        Queue<int[]> queue = new LinkedList<>();
        queue.offer(new int[]{startY, startX});
        visited[startY][startX] = true;

        // 방향 배열 (상, 하, 좌, 우)
        int[] dy = {-1, 1, 0, 0};
        int[] dx = {0, 0, -1, 1};

        while (!queue.isEmpty()) {
            int[] position = queue.poll();
            int y = position[0];
            int x = position[1];

            for (int d = 0; d < 4; d++) {
                int newY = y + dy[d];
                int newX = x + dx[d];

                if (newY >= 0 && newY < N && newX >= 0 && newX < M && field[newY][newX] == 1 && !visited[newY][newX]) {
                    visited[newY][newX] = true;
                    queue.offer(new int[]{newY, newX});
                }
            }
        }
    }
}

package silver;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class BJ21736 {

    static char[][] campus; // 캠퍼스 정보를 담는 2차원 배열
    static boolean[][] visited; // 방문 여부
    static int N, M; // 캠퍼스의 크기
    // 상, 하, 좌, 우 이동을 위한 배열
    static int[] dx = { -1, 1, 0, 0 };
    static int[] dy = { 0, 0, -1, 1 };

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        M = sc.nextInt();
        campus = new char[N][M];
        visited = new boolean[N][M];

        int startX = 0, startY = 0;

        for (int i = 0; i < N; i++) {
            String input = sc.next();
            for (int j = 0; j < M; j++) {
                campus[i][j] = input.charAt(j);
                if (campus[i][j] == 'I') {
                    startX = i;
                    startY = j;
                }
            }
        }

        // BFS를 통해 탐색한 결과 출력
        int result = bfs(startX, startY);
        if (result == 0) {
            System.out.println("TT");
        } else {
            System.out.println(result);
        }
    }

    public static int bfs(int x, int y) {
        Queue<int[]> queue = new LinkedList<>();
        queue.offer(new int[] { x, y }); // 시작점 큐에 넣기
        visited[x][y] = true; // 시작점 방문 처리

        int peopleCount = 0;

        // BFS 시작
        while (!queue.isEmpty()) {
            int[] current = queue.poll(); // 현재 좌표 꺼내기
            int cx = current[0];
            int cy = current[1];

            // 상하좌우로 이동할 수 있는 모든 방향 탐색
            for (int i = 0; i < 4; i++) {
                int nx = cx + dx[i];
                int ny = cy + dy[i];

                // 캠퍼스 범위 내에서 이동 가능한 경우
                if (nx >= 0 && ny >= 0 && nx < N && ny < M && !visited[nx][ny] && campus[nx][ny] != 'X') {
                    visited[nx][ny] = true;
                    queue.offer(new int[] { nx, ny });

                    // 만난 사람이면 카운트 증가
                    if (campus[nx][ny] == 'P') {
                        peopleCount++;
                    }
                }
            }
        }

        return peopleCount;
    }
}

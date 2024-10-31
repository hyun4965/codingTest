package gold;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class BJ10026 {
    static char[][] graph; // 그리드 정보를 담는 2차원 배열
    static boolean[][] visited; // 방문 여부
    static int N; // 그리드 크기
    static int[] dx = { -1, 1, 0, 0 }; // 상하좌우 이동 배열
    static int[] dy = { 0, 0, -1, 1 };

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt(); //배열 크기 선언
        graph = new char[N][N]; //배열 생성

        // 입력하기
        for (int i = 0; i < N; i++) {
            String input = sc.next();
            for (int j = 0; j < N; j++) {
                graph[i][j] = input.charAt(j);
            }
        }

        // 적록색약이 아닌 사람의 구역 수
        visited = new boolean[N][N];
        int normalCount = 0;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (!visited[i][j]) {
                    bfs(i, j, graph[i][j], false);
                    normalCount++; //색약 X
                }
            }
        }

        // 적록색약인 사람의 구역 수
        visited = new boolean[N][N];
        int colorBlindCount = 0;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (!visited[i][j]) {
                    bfs(i, j, graph[i][j], true);
                    colorBlindCount++; //색약 O
                }
            }
        }

        System.out.println(normalCount + " " + colorBlindCount);
    }

    // BFS 탐색 함수
    public static void bfs(int x, int y, char color, boolean colorBlind) {
        Queue<int[]> queue = new LinkedList<>();
        queue.offer(new int[] { x, y });
        visited[x][y] = true;

        while (!queue.isEmpty()) {
            int[] current = queue.poll();
            int cx = current[0];
            int cy = current[1];

            for (int i = 0; i < 4; i++) {
                int nx = cx + dx[i];
                int ny = cy + dy[i];

                if (nx >= 0 && ny >= 0 && nx < N && ny < N && !visited[nx][ny]) {
                    if (colorBlind) { // 적록색약인 경우
                        if ((color == 'R' || color == 'G') && (graph[nx][ny] == 'R' || graph[nx][ny] == 'G')) {
                            visited[nx][ny] = true;
                            queue.offer(new int[] { nx, ny });
                        } else if (graph[nx][ny] == color) {
                            visited[nx][ny] = true;
                            queue.offer(new int[] { nx, ny });
                        }
                    } else { // 적록색약이 아닌 경우
                        if (graph[nx][ny] == color) {
                            visited[nx][ny] = true;
                            queue.offer(new int[] { nx, ny });
                        }
                    }
                }
            }
        }
    }
}

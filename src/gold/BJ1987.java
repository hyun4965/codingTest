package gold;

import java.util.Scanner;

public class BJ1987 {
    static int R, C;
    static char[][] board;
    static boolean[] visited = new boolean[26]; // 알파벳 A~Z 방문 여부
    static int max = 0;

    // 상, 하, 좌, 우
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        R = sc.nextInt();
        C = sc.nextInt();
        sc.nextLine(); // 버퍼 비우기

        board = new char[R][C];

        for (int i = 0; i < R; i++) {
            String line = sc.nextLine();
            for (int j = 0; j < C; j++) {
                board[i][j] = line.charAt(j);
            }
        }

        // 시작 알파벳 방문 표시
        visited[board[0][0] - 'A'] = true;
        dfs(0, 0, 1); // 시작 좌표 (0,0), 경로 길이 1부터 시작

        System.out.println(max);
    }

    public static void dfs(int x, int y, int count) {
        max = Math.max(max, count);

        for (int i = 0; i < 4; i++) {
            int nx = x + dx[i];
            int ny = y + dy[i];

            if (nx >= 0 && nx < R && ny >= 0 && ny < C) {
                int nextAlpha = board[nx][ny] - 'A';
                if (!visited[nextAlpha]) {
                    visited[nextAlpha] = true;
                    dfs(nx, ny, count + 1);
                    visited[nextAlpha] = false;
                }
            }
        }
    }
}


package gold;

import java.util.Scanner;

public class BJ14500 {
    static int[][] arr;
    static boolean[][] visited;
    static int N, M, maxSum = 0;
    static int[] dx = {0, 1, 0, -1}; // 상하좌우 이동
    static int[] dy = {1, 0, -1, 0};

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        M = sc.nextInt();
        arr = new int[N][M];
        visited = new boolean[N][M];

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                arr[i][j] = sc.nextInt();
            }
        }

        // 모든 시작점에 대해 DFS 수행
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                visited[i][j] = true;
                dfs(i, j, 0, arr[i][j]);
                visited[i][j] = false;

                // ㅗ 모양 처리 (특수 케이스)
                checkSpecialShape(i, j);
            }
        }

        System.out.println(maxSum);
    }

    // DFS로 테트로미노의 합 계산
    private static void dfs(int x, int y, int depth, int sum) {
        if (depth == 3) { // 테트로미노의 4칸을 탐색했으면 종료
            maxSum = Math.max(maxSum, sum);
            return;
        }

        for (int i = 0; i < 4; i++) {
            int nx = x + dx[i];
            int ny = y + dy[i];

            // 유효 범위 및 방문 여부 확인
            if (nx >= 0 && ny >= 0 && nx < N && ny < M && !visited[nx][ny]) {
                visited[nx][ny] = true;
                dfs(nx, ny, depth + 1, sum + arr[nx][ny]);
                visited[nx][ny] = false; // 백트래킹
            }
        }
    }

    // ㅗ 모양 (회전 및 대칭 포함) 처리
    private static void checkSpecialShape(int x, int y) {
        // ㅗ, ㅜ, ㅓ, ㅏ 모양 탐색
        int[][] shapes = {
                {0, 1, 0, -1, 1, 0},  // ㅗ
                {0, 1, 0, -1, -1, 0}, // ㅜ
                {-1, 0, 1, 0, 0, 1},  // ㅓ
                {-1, 0, 1, 0, 0, -1}  // ㅏ
        };

        for (int[] shape : shapes) {
            int sum = arr[x][y];
            boolean isValid = true;

            for (int i = 0; i < 3; i++) {
                int nx = x + shape[i * 2];
                int ny = y + shape[i * 2 + 1];

                if (nx < 0 || ny < 0 || nx >= N || ny >= M) {
                    isValid = false;
                    break;
                }

                sum += arr[nx][ny];
            }

            if (isValid) {
                maxSum = Math.max(maxSum, sum);
            }
        }
    }
}

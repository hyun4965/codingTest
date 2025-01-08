package gold;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class BJ14502 {
    static int[][] lab; // 연구실
    static int[][] copyedlab; // 복사된 연구실
    static int N, M, result = 0;
    static int[] dx = { -1, 1, 0, 0 }; // 상하좌우 이동
    static int[] dy = { 0, 0, -1, 1 };

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt(); // 세로
        M = sc.nextInt(); // 가로

        lab = new int[N][M];
        copyedlab = new int[N][M]; // 복사본 배열 초기화

        // 연구소 초기화
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                lab[i][j] = sc.nextInt();
            }
        }

        buildWall(0);
        System.out.println(result);
    }

    static void buildWall(int count) {
        if (count == 3) {
            copyLab(); //현재 lab 복사
            spreadVirus();
            result = Math.max(result, getSafeArea());
            return;
        }

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (lab[i][j] == 0) { // 빈 칸에 벽 세우기
                    lab[i][j] = 1;
                    buildWall(count + 1);
                    lab[i][j] = 0; // 원상복구
                }
            }
        }
    }

    static void copyLab() {
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                copyedlab[i][j] = lab[i][j];
            }
        }
    }

    static void spreadVirus() {
        Queue<int[]> queue = new LinkedList<>();

        // 바이러스 위치 추가
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (copyedlab[i][j] == 2) {
                    queue.add(new int[] { i, j });
                }
            }
        }

        while (!queue.isEmpty()) {
            int[] current = queue.poll();
            int x = current[0];
            int y = current[1];

            for (int d = 0; d < 4; d++) {
                int nx = x + dx[d];
                int ny = y + dy[d];

                if (nx >= 0 && ny >= 0 && nx < N && ny < M) {
                    if (copyedlab[nx][ny] == 0) { // 빈 칸이면 바이러스 확산
                        copyedlab[nx][ny] = 2;
                        queue.add(new int[] { nx, ny });
                    }
                }
            }
        }
    }

    static int getSafeArea() {
        int count = 0;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (copyedlab[i][j] == 0) {
                    count++;
                }
            }
        }
        return count;
    }
}

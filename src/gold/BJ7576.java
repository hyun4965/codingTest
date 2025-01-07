package gold;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class BJ7576 {
    static int N; //가로 칸수
    static int M; //세로 칸수
    static int[] dx = { -1, 1, 0, 0 };
    static int[] dy = { 0, 0, -1, 1 };
    static int[][] board;
    static boolean[][] visited;
    static Queue<int[]> queue = new LinkedList<>();

    /*
        1 : 토마토 O , 0: 토마토 X , -1 : 빈칸
     */
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        M = sc.nextInt();
        N = sc.nextInt();
        board = new int[N][M];
        visited = new boolean[N][M];

        boolean valid = true;

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                board[i][j] = sc.nextInt();
                if (board[i][j] == 1) {
                    queue.add(new int[]{i, j});
                    visited[i][j] = true;
                } else if (board[i][j] == 0) {
                    valid = false; // 익지 않은 토마토가 있음
                }
            }
        }

        //모든수가 익음
        if(valid){
            System.out.println(0);
            return;
        }
        int result =findDate();
        // 모든 토마토가 익었는지 확인
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (board[i][j] == 0) {
                    System.out.println(-1); // 익지 못한 토마토가 있음
                    return;
                }
            }
        }

        System.out.println(result);

    }
    private static int findDate() {
        int day = 0;

        while (!queue.isEmpty()) {
            int size = queue.size();

            // 하루 동안 익히기
            for (int i = 0; i < size; i++) {
                int[] current = queue.poll();
                int x = current[0];
                int y = current[1];

                for (int dir = 0; dir < 4; dir++) {
                    int nextX = x + dx[dir];
                    int nextY = y + dy[dir];

                    if (nextX >= 0 && nextX < N && nextY >= 0 && nextY < M && board[nextX][nextY] == 0 && !visited[nextX][nextY]) {
                        visited[nextX][nextY] = true; // 방문 처리
                        board[nextX][nextY] = 1; // 익히기
                        queue.add(new int[]{nextX, nextY});
                    }
                }
            }
            day++;
        }

        return day-1;
    }
}

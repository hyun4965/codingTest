package gold;

import java.util.Scanner;
import java.util.LinkedList;
import java.util.Queue;

public class BJ16197 {
    static int N, M;
    static char[][] board;
    static int[] dx = {0, 1, 0, -1};
    static int[] dy = {1, 0, -1, 0};
    static Coin[] coin; // 동전의 위치 저장.
    static boolean[][][][] visited;

    public static class Coin { // 동전의 좌표를 기억하는 객체
        int x;
        int y;

        public Coin(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    public static class State {
        Coin coin1;
        Coin coin2;
        int depth;

        public State(Coin coin1, Coin coin2, int depth) {
            this.coin1 = coin1;
            this.coin2 = coin2;
            this.depth = depth;
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        M = sc.nextInt();
        board = new char[N][M];
        coin = new Coin[2];

        int coinIdx = 0;
        for (int i = 0; i < N; i++) {
            String str = sc.next();
            for (int j = 0; j < M; j++) {
                char c = str.charAt(j);
                if (c == 'o') {
                    coin[coinIdx++] = new Coin(i, j); // 코인의 위치 저장
                }
                board[i][j] = c;
            }
        }

        visited = new boolean[N][M][N][M]; // [첫번째 동전의 x][y][두번째 동전의 x][y]
        System.out.println(bfs());
    }

    public static int bfs() {
        Queue<State> queue = new LinkedList<>();
        queue.add(new State(coin[0], coin[1], 0));
        visited[coin[0].x][coin[0].y][coin[1].x][coin[1].y] = true;

        while (!queue.isEmpty()) {
            State current = queue.poll();

            if (current.depth >= 10) {
                return -1;
            }

            for (int i = 0; i < 4; i++) {
                int nx1 = current.coin1.x + dx[i];
                int ny1 = current.coin1.y + dy[i];
                int nx2 = current.coin2.x + dx[i];
                int ny2 = current.coin2.y + dy[i];

                boolean coin1Out = nx1 < 0 || nx1 >= N || ny1 < 0 || ny1 >= M;
                boolean coin2Out = nx2 < 0 || nx2 >= N || ny2 < 0 || ny2 >= M;

                if (coin1Out && coin2Out) {
                    continue;
                }

                if (coin1Out || coin2Out) {
                    return current.depth + 1;
                }

                if (nx1 >= 0 && nx1 < N && ny1 >= 0 && ny1 < M && board[nx1][ny1] == '#') {
                    nx1 = current.coin1.x;
                    ny1 = current.coin1.y;
                }

                if (nx2 >= 0 && nx2 < N && ny2 >= 0 && ny2 < M && board[nx2][ny2] == '#') {
                    nx2 = current.coin2.x;
                    ny2 = current.coin2.y;
                }

                if (!visited[nx1][ny1][nx2][ny2]) {
                    visited[nx1][ny1][nx2][ny2] = true;
                    queue.add(new State(new Coin(nx1, ny1), new Coin(nx2, ny2), current.depth + 1));
                }
            }
        }

        return -1;
    }
}

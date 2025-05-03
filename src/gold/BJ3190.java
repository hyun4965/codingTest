package gold;

import java.util.*;

public class BJ3190 {
    static int N;
    static int[][] board;
    static Deque<int[]> snake = new LinkedList<>();
    static Map<Integer, Character> map = new HashMap<>();

    static int[] dx = {0, 1, 0, -1};
    static int[] dy = {1, 0, -1, 0};

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        board = new int[N][N];

        //사과 위치
        int K = sc.nextInt();
        for (int i = 0; i < K; i++) {
            int r = sc.nextInt() - 1;
            int c = sc.nextInt() - 1;
            board[r][c] = 1;
        }

        //뱀의 방향 횟수
        int L = sc.nextInt();
        for (int i = 0; i < L; i++) {
            int t = sc.nextInt();
            char dir = sc.next().charAt(0);
            map.put(t, dir);
        }

        int time = 0;
        int dir = 0; // 시작 방향: 오른쪽
        snake.add(new int[]{0, 0});
        board[0][0] = 2; // 뱀의 위치: 2

        while (true) {
            time++;
            int[] head = snake.peekFirst();
            int nx = head[0] + dx[dir];
            int ny = head[1] + dy[dir];

            // 벽 또는 자기자신과 충돌
            if (nx < 0 || ny < 0 || nx >= N || ny >= N || board[nx][ny] == 2) {
                break;
            }

            if (board[nx][ny] == 1) {
                board[nx][ny] = 2;
                snake.addFirst(new int[]{nx, ny});
            } else { // 빈칸
                board[nx][ny] = 2;
                snake.addFirst(new int[]{nx, ny});
                int[] tail = snake.pollLast();
                board[tail[0]][tail[1]] = 0;
            }

            // 방향 전환
            if (map.containsKey(time)) {
                char turn = map.get(time);
                if (turn == 'D') {
                    dir = (dir + 1) % 4;
                } else {
                    dir = (dir + 3) % 4;
                }
            }
        }

        System.out.println(time);
    }
}

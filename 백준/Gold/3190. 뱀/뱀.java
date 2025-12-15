import java.io.*;
import java.util.*;

public class Main {
    static int N, K, L;
    static int[][] board;
    static Map<Integer, Character> turn = new HashMap<>();

    static int[] dr = {0, 1, 0, -1};
    static int[] dc = {1, 0, -1, 0};

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());
        board = new int[N + 1][N + 1]; 

        K = Integer.parseInt(br.readLine());
        for (int i = 0; i < K; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int r = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());
            board[r][c] = 1; 
        }

        L = Integer.parseInt(br.readLine());
        for (int i = 0; i < L; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            char c = st.nextToken().charAt(0);
            turn.put(x, c);
        }

        System.out.println(simulate());
    }

    static int simulate() {
        Deque<int[]> snake = new ArrayDeque<>();
        snake.addLast(new int[]{1, 1});
        board[1][1] = 2;

        int time = 0;
        int dir = 0; 
        int headR = 1, headC = 1;

        while (true) {
            time++;

            int nr = headR + dr[dir];
            int nc = headC + dc[dir];

            if (nr < 1 || nr > N || nc < 1 || nc > N) return time;

            if (board[nr][nc] == 2) return time;

            snake.addLast(new int[]{nr, nc});

            if (board[nr][nc] == 1) {
                board[nr][nc] = 2;
            } else {
                board[nr][nc] = 2;
                int[] tail = snake.pollFirst();
                board[tail[0]][tail[1]] = 0;
            }

            headR = nr;
            headC = nc;

            if (turn.containsKey(time)) {
                char t = turn.get(time);
                if (t == 'L') {
                    dir = (dir + 3) % 4;
                }
                else if (t == 'D') {
                    dir = (dir + 1) % 4;
                }
            }
        }
    }
}

package gold;
import java.util.Scanner;

public class BJ14499 {
    static int N, M, x, y, K;
    static int[][] map;
    static int[] commands;
    static int[] dice = new int[7];

    // 동 서 북 남
    static int[] dx = {0, 0, 0, -1, 1};
    static int[] dy = {0, 1, -1, 0, 0};

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        N = sc.nextInt();
        M = sc.nextInt();
        x = sc.nextInt();
        y = sc.nextInt();
        K = sc.nextInt();

        map = new int[N][M];
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                map[i][j] = sc.nextInt();
            }
        }

        commands = new int[K];
        for (int i = 0; i < K; i++) {
            commands[i] = sc.nextInt();
        }

        for (int dir : commands) {
            int nx = x + dx[dir];
            int ny = y + dy[dir];

            if (nx < 0 || ny < 0 || nx >= N || ny >= M) {
                continue;
            }

            rollDice(dir);
            x = nx;
            y = ny;

            // 복사 규칙 처리
            if (map[x][y] == 0) {
                map[x][y] = dice[6];
            } else {
                dice[6] = map[x][y];
                map[x][y] = 0;
            }

            System.out.println(dice[1]);
        }
    }

    // 주사위 굴리기
    static void rollDice(int dir) {
        int[] temp = dice.clone();

        switch (dir) {
            case 1: // 동
                dice[1] = temp[4];
                dice[3] = temp[1];
                dice[6] = temp[3];
                dice[4] = temp[6];
                break;
            case 2: // 서
                dice[1] = temp[3];
                dice[4] = temp[1];
                dice[6] = temp[4];
                dice[3] = temp[6];
                break;
            case 3: // 북
                dice[1] = temp[5];
                dice[2] = temp[1];
                dice[6] = temp[2];
                dice[5] = temp[6];
                break;
            case 4: // 남
                dice[1] = temp[2];
                dice[5] = temp[1];
                dice[6] = temp[5];
                dice[2] = temp[6];
                break;
        }
    }
}

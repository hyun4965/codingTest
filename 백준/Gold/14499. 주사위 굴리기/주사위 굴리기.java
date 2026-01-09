import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int N, M, X, Y;
    static int[][] map;
    static int[] dice;

    static int[] dx = {0, 0, -1, 1};
    static int[] dy = {1, -1, 0, 0};

    static StringBuilder sb;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        sb = new StringBuilder();

        N = Integer.parseInt(st.nextToken()); //세로
        M = Integer.parseInt(st.nextToken()); //가로
        X = Integer.parseInt(st.nextToken()); //좌표
        Y = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken()); //명령의 갯수

        map = new int[N][M];
        dice = new int[6];

        for(int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for(int j = 0; j < M; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < k; i++) {
            int num = Integer.parseInt(st.nextToken());
            Simulation(num - 1);
        }

        System.out.println(sb.toString());
    }

    static void Simulation(int num) {
        int nx = X + dx[num];
        int ny = Y + dy[num];

        if(nx < 0 || ny < 0 || nx >= N || ny >= M){
            return;
        }

        int temp = dice[5];

        switch (num) {
            case 0:
                dice[5] = dice[2];
                dice[2] = dice[0];
                dice[0] = dice[3];
                dice[3] = temp;
                break;
            case 1:
                dice[5] = dice[3];
                dice[3] = dice[0];
                dice[0] = dice[2];
                dice[2] = temp;
                break;
            case 2:
                dice[5] = dice[4];
                dice[4] = dice[0];
                dice[0] = dice[1];
                dice[1] = temp;
                break;

            default:
                dice[5] = dice[1];
                dice[1] = dice[0];
                dice[0] = dice[4];
                dice[4] = temp;
        }

        sb.append(dice[0]).append("\n");

        X = nx;
        Y = ny;

        if(map[X][Y] == 0) {
            map[X][Y] = dice[5];
        } else {
            dice[5] = map[X][Y];
            map[X][Y] = 0;
        }
    }
}
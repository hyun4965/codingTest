package gold;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BJ20055 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken()); // 윗벨트 길이
        int K = Integer.parseInt(st.nextToken()); // 종료조건

        st = new StringTokenizer(br.readLine());
        int[] belt = new int[2 * N];
        for (int i = 0; i < 2 * N; i++) {
            belt[i] = Integer.parseInt(st.nextToken());
        }

        boolean[] robot = new boolean[N];
        int step = 0;
        while (true) {
            step++;

            int last = belt[2 * N - 1];
            for (int i = 2 * N - 1; i > 0; i--) {
                belt[i] = belt[i - 1];
            }
            belt[0] = last;

            for (int i = N - 1; i > 0; i--) {
                robot[i] = robot[i - 1];
            }
            robot[0] = false;

            if (robot[N - 1]) {
                robot[N - 1] = false;
            }

            for (int i = N - 2; i >= 0; i--) {
                if (robot[i]) {
                    if (!robot[i + 1] && belt[i + 1] > 0) {
                        robot[i] = false;
                        robot[i + 1] = true;
                        belt[i + 1]--;

                    }
                }
            }
            if (robot[N - 1]) {
                robot[N - 1] = false;
            }

            if (belt[0] > 0 && !robot[0]) {
                robot[0] = true;
                belt[0]--;
            }

            int zeroCount = 0;
            for (int d : belt) {
                if (d == 0) {
                    zeroCount++;
                }
            }
            if (zeroCount >= K) {
                System.out.println(step);
                break;
            }
        }
    }
}

package news;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class BJ1562 {
    static final int MOD = 1_000_000_000;
    static final int FULL = (1 << 10) - 1;


    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        int[][] prev = new int[10][1 << 10];
        int[][] cur = new int[10][1 << 10];

        for (int i = 1; i <= 9; i++) {
            prev[i][1 << i] = 1;
        }

        for (int i = 2; i <= n; i++) {
            for (int j = 0; j < 10; j++) {
                Arrays.fill(cur[j], 0);
            }

            for (int j = 0; j < 10; j++) {
                for (int mask = 0; mask <= FULL; mask++) {
                    int val = prev[j][mask];
                    if (val == 0) {
                        continue;
                    }

                    if (j > 0) {
                        int nm = mask | (1 << (j - 1));
                        cur[j - 1][nm] = (cur[j - 1][nm] + val) % MOD;
                    }

                    if (j < 9) {
                        int nm = mask | (1 << (j + 1));
                        cur[j + 1][nm] = (cur[j + 1][nm] + val) % MOD;
                    }
                }
            }

            int[][] tmp = prev;
            prev = cur;
            cur = tmp;
        }

        long answer = 0;
        for (int i = 0; i < 10; i++) {
            answer += prev[i][FULL];
        }
        System.out.println(answer % MOD);
    }
}

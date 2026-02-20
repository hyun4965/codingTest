package gold;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BJ13172 {
    static final long MOD = 1_000_000_007L;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int M = Integer.parseInt(br.readLine());
        StringTokenizer st;

        long N = 1L;
        long S = 0L;

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            long n = Long.parseLong(st.nextToken());
            long s = Long.parseLong(st.nextToken());

            S = (s * N + S * n) % MOD;
            N = (N * n) % MOD;
        }

        long answer = (S * modPow(N, MOD - 2)) % MOD;
        System.out.print(answer);
    }

    static long modPow(long a, long e) {
        if (e == 1) {
            return a % MOD;
        }
        long half = modPow(a, e / 2);
        long result = (half * half) % MOD;
        if (e % 2 == 1) {
            result = (result * a) % MOD;
        }
        return result;
    }
}
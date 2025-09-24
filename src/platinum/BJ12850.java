package platinum;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BJ12850 {
    static final int MOD = 1_000_000_007;
    static final int SIZE = 8;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int D = Integer.parseInt(br.readLine());

        // 정답 그래프(인접 행렬)
        // 노드: 0 정보과학관, 1 전산관, 2 미래관, 3 신양관,
        //       4 한경직기념관, 5 진리관, 6 학생회관, 7 형남공학관
        long[][] M = {
                //0  1  2  3  4  5  6  7
                { 0, 1, 1, 0, 0, 0, 0, 0 }, // 0: 1,2
                { 1, 0, 1, 1, 0, 0, 0, 0 }, // 1: 0,2,3
                { 1, 1, 0, 1, 1, 0, 0, 0 }, // 2: 0,1,3,4
                { 0, 1, 1, 0, 1, 1, 0, 0 }, // 3: 1,2,4,5
                { 0, 0, 1, 1, 0, 1, 0, 1 }, // 4: 2,3,5,7
                { 0, 0, 0, 1, 1, 0, 1, 0 }, // 5: 3,4,6
                { 0, 0, 0, 0, 0, 1, 0, 1 }, // 6: 5,7
                { 0, 0, 0, 0, 1, 0, 1, 0 }  // 7: 4,6
        };

        long[][] result = power(M, D);
        System.out.println(result[0][0] % MOD);
    }

    // 행렬 곱셈 (mod 포함, 0 스킵으로 미세 최적화)
    private static long[][] multiply(long[][] A, long[][] B) {
        long[][] C = new long[SIZE][SIZE];
        for (int i = 0; i < SIZE; i++) {
            for (int k = 0; k < SIZE; k++) {
                if (A[i][k] == 0) {
                    continue;
                }
                long aik = A[i][k];
                for (int j = 0; j < SIZE; j++) {
                    if (B[k][j] == 0) {
                        continue;
                    }
                    C[i][j] = (C[i][j] + aik * B[k][j]) % MOD;
                }
            }
        }
        return C;
    }

    private static long[][] power(long[][] M, int e) {
        if (e == 1) return M;
        long[][] half = power(M, e / 2);
        long[][] sq = multiply(half, half);
        if ((e & 1) == 1) {
            sq = multiply(sq, M);
        }
        return sq;
    }
}

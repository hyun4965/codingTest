package silver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class GoldbachPartition {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());

        int maxN = 1000000;
        boolean[] isPrime = new boolean[maxN + 1];

        //true로 초기화
        for (int i = 2; i <= maxN; i++) {
            isPrime[i] = true;
        }

        //소수 계산
        for (int i = 2; i * i <= maxN; i++) {
            if (isPrime[i]) {
                for (int j = i * i; j <= maxN; j += i) {
                    isPrime[j] = false;
                }
            }
        }

        for (int t = 0; t < T; t++) {
            int N = Integer.parseInt(br.readLine());
            int count = 0;

            for (int i = 2; i <= N / 2; i++) {
                if (isPrime[i] && isPrime[N - i]) {
                    count++;
                }
            }
            System.out.println(count);
        }
    }
}
package bronze;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BJ28214 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // 첫 번째 줄 입력 (N, K, P)
        String input = br.readLine();
        String[] numbers = input.split(" ");
        int N = Integer.parseInt(numbers[0]);
        int K = Integer.parseInt(numbers[1]);
        int P = Integer.parseInt(numbers[2]);

        // 두 번째 줄 입력 (빵 크림 여부)
        String[] creamInput = br.readLine().split(" ");
        int[] cream = new int[N * K];
        for (int i = 0; i < N * K; i++) {
            cream[i] = Integer.parseInt(creamInput[i]);
        }

        // 팔 수 있는 묶음의 수 계산
        int sellableBundles = 0;
        for (int i = 0; i < N; i++) {
            int start = i * K;
            int end = start + K;
            int noCreamCount = 0;

            // K개 묶음 내 크림 없는 빵 개수 세기
            for (int j = start; j < end; j++) {
                if (cream[j] == 0) {
                    noCreamCount++;
                }
            }

            // 크림 없는 빵이 P개 미만이면 팔 수 있음
            if (noCreamCount < P) {
                sellableBundles++;
            }
        }

        // 결과 출력
        System.out.println(sellableBundles);
    }
}
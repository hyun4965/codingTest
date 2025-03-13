package gold;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BJ2138 {
    static int N;
    static char[] current, target;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        current = br.readLine().toCharArray();
        target = br.readLine().toCharArray();

        int result1 = simulate(current.clone(), true);  // 첫 번째 전구를 눌렀을 경우
        int result2 = simulate(current.clone(), false); // 첫 번째 전구를 누르지 않았을 경우

        int result = Math.min(result1, result2);
        System.out.println(result == Integer.MAX_VALUE ? -1 : result);
    }
    private static int simulate(char[] bulbs, boolean firstSwitch) {
        int count = 0;
        if (firstSwitch) {
            for (int i = 0; i <= 1; i++) {
                if (i < N) {
                    bulbs[i] = (bulbs[i] == '0') ? '1' : '0';
                }
            }
            count++;
        }

        for (int i = 1; i < N; i++) {
            if (bulbs[i - 1] != target[i - 1]) { // 이전 전구가 목표 상태와 다르면 눌러야 함
                for (int j = i - 1; j <= i + 1; j++) {
                    if (j >= 0 && j < N) {
                        bulbs[j] = (bulbs[j] == '0') ? '1' : '0';
                    }
                }
                count++;
            }
        }
        return (bulbs[N - 1] == target[N - 1]) ? count : Integer.MAX_VALUE;
    }
}

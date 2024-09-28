package silver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

//백준 실버 11726
public class Xn {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        int[] dp = new int[n + 1];

        dp[1] = 1;// dp[1]은 1로 초기화됩니다. (2×1 크기의 직사각형은 하나의 방법만 존재)
        if (n > 1) {
            dp[2] = 2; //dp[2]는 2로 초기화됩니다. (2×2 크기의 직사각형은 두 가지 방법으로 채울 수 있음)
        }

        for (int i = 3; i <= n; i++) {
            dp[i] = (dp[i-1] + dp[i-2]) % 10007; //dp[i-1] + dp[i-2]의 값에 10,007로 나눈 나머지를 저장하여 오버플로우를 방지
        }

        System.out.println(dp[n]);
    }
}

package gold;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BJ10942 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine()); //수열의 크기

        int[] nums = new int[n + 1];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= n; i++) {
            nums[i] = Integer.parseInt(st.nextToken());
        }

        boolean[][] dp = new boolean[n + 1][n + 1];


        for (int i = 1; i <= n; i++) {
            dp[i][i] = true;
        }

        for (int i = 1; i <= n - 1; i++) {
            if (nums[i] == nums[i + 1]) {
                dp[i][i + 1] = true;
            }
        }


        for (int i = 3; i <= n; i++) {
            for (int start = 1; start <= n - i + 1; start++) {
                int end = start + i - 1;
                if (nums[start] == nums[end] && dp[start + 1][end - 1]) {
                    dp[start][end] = true;
                }
            }
        }

        int m = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());

            if (dp[start][end]) {
                sb.append("1\n");
            } else {
                sb.append("0\n");
            }
        }
        System.out.print(sb.toString());
    }
}

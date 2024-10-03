package gold;

import java.io.*;
import java.util.*;


//백준 골드 14002
public class LongSequence4 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int N = Integer.parseInt(br.readLine());

        int[] dp = new int[N];
        int[] arr = new int[N];

        int max = 0;
        StringTokenizer st = new StringTokenizer(br.readLine());

        // 수열 입력
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        // 가장 긴 증가하는 부분 수열 길이 계산
        for (int i = 0; i < N; i++) {
            dp[i] = 1;
            for (int j = 0; j < i; j++) {
                if (arr[j] < arr[i] && dp[j] + 1 > dp[i]) {
                    dp[i] = dp[j] + 1;
                }
            }
        }

        // 가장 긴 증가하는 부분 수열 길이 구하기
        for (int i = 0; i < N; i++) {
            max = Math.max(dp[i], max);
        }
        // 가장 긴 수열 길이 출력
        sb.append(max).append("\n");

        // 가장 긴 증가하는 부분 수열 찾기
        int[] longestSeq = new int[max];
        int count = max;
        for (int i = N - 1; i >= 0; i--) {
            if (dp[i] == count) {
                longestSeq[--count] = arr[i];
            }
        }

        // 결과 출력
        for (int i = 0; i < max; i++) {
            sb.append(longestSeq[i]).append(" ");
        }

        System.out.println(sb);
    }
}

package silver;

import java.util.*;

public class BJ2512 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();
        int[] requests = new int[N];
        int maxRequest = 0;
        for (int i = 0; i < N; i++) {
            requests[i] = sc.nextInt();
            maxRequest = Math.max(maxRequest, requests[i]);
        }

        int M = sc.nextInt();

        int left = 0;
        int right = maxRequest;
        int answer = 0;

        while (left <= right) {
            int mid = (left + right) / 2;

            long total = 0;
            for (int r : requests) {
                total += Math.min(r, mid);
            }

            if (total <= M) {
                answer = mid;       // 가능한 경우: 더 높여보기
                left = mid + 1;
            } else {
                right = mid - 1;    // 불가능하므로 상한 줄이기
            }
        }

        System.out.println(answer);
    }
}

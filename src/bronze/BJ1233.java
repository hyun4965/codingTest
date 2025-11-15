package bronze;

import java.util.Scanner;

public class BJ1233 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int S1 = sc.nextInt();
        int S2 = sc.nextInt();
        int S3 = sc.nextInt();

        int maxSum = S1 + S2 + S3;   // 최대 합
        int[] freq = new int[maxSum + 1]; // 합 빈도 저장 배열

        // 모든 경우의 수 탐색
        for (int i = 1; i <= S1; i++) {
            for (int j = 1; j <= S2; j++) {
                for (int k = 1; k <= S3; k++) {
                    freq[i + j + k]++;
                }
            }
        }

        // 가장 많이 나온 합 찾기
        int maxFreq = 0;
        int answer = 0;
        for (int sum = 3; sum <= maxSum; sum++) { // 최소합은 1+1+1=3
            if (freq[sum] > maxFreq) {
                maxFreq = freq[sum];
                answer = sum;
            }
        }

        System.out.println(answer);
    }
}

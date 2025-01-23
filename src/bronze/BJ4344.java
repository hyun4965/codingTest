package bronze;

import java.util.Scanner;

public class BJ4344 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int C = sc.nextInt(); // 테스트 케이스 수

        for (int i = 0; i < C; i++) {
            int N = sc.nextInt(); // 학생 수
            int[] scores = new int[N];
            double sum = 0;

            for (int j = 0; j < N; j++) {
                scores[j] = sc.nextInt();
                sum += scores[j];
            }

            double avg = sum / N;
            int count = 0;

            for (int score : scores) {
                if (score > avg) {
                    count++;
                }
            }

            double ratio = (double) count / N * 100;
            System.out.printf("%.3f%%\n", ratio);
        }
    }
}
package bronze;

import java.util.Scanner;

public class BJ13458 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt(); // 시험장 수
        int[] students = new int[n]; // 각 시험장 응시자 수

        for (int i = 0; i < n; i++) {
            students[i] = sc.nextInt();
        }

        int B = sc.nextInt(); // 총감독관 감시 인원 수
        int C = sc.nextInt(); // 부감독관 감시 인원 수

        long count = 0;

        for (int i = 0; i < n; i++) {
            int remain = students[i] - B; // 총감독관이 감시하고 남은 인원
            count++; // 총감독관은 무조건 1명

            if (remain > 0) {
                count += (remain + C - 1) / C;
            }
        }

        System.out.println(count);
    }
}

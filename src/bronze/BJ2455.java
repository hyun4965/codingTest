package bronze;

import java.util.Scanner;

public class BJ2455 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int current = 0;  // 현재 기차 안에 있는 사람 수
        int max = 0;      // 가장 많았던 사람 수

        for (int i = 0; i < 4; i++) {
            int off = sc.nextInt(); // 내린 사람 수
            int on = sc.nextInt();  // 탄 사람 수

            current = current - off + on;

            // 최대 인원 수 갱신
            if (current > max) {
                max = current;
            }
        }

        System.out.println(max);
    }
}

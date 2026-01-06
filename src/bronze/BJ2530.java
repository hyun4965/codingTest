package bronze;

import java.util.Scanner;

public class BJ2530 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int A = sc.nextInt(); // 시
        int B = sc.nextInt(); // 분
        int C = sc.nextInt(); // 초
        int D = sc.nextInt(); // 추가 초

        int totalSeconds = A * 3600 + B * 60 + C;

        totalSeconds += D;

        totalSeconds %= 86400;

        int hour = totalSeconds / 3600;
        int minute = (totalSeconds % 3600) / 60;
        int second = totalSeconds % 60;

        System.out.println(hour + " " + minute + " " + second);
    }
}

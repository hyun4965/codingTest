package silver;

import java.util.Scanner;

public class BJ1002 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();

        for (int t = 0; t < T; t++) {
            int x1 = sc.nextInt();
            int y1 = sc.nextInt();
            int r1 = sc.nextInt();
            int x2 = sc.nextInt();
            int y2 = sc.nextInt();
            int r2 = sc.nextInt();

            int dx = x2 - x1;
            int dy = y2 - y1;
            int distanceSq = dx * dx + dy * dy; // 거리의 제곱
            int sumR = r1 + r2;
            int diffR = Math.abs(r1 - r2);

            if (distanceSq == 0) {
                if (r1 == r2) {
                    System.out.println(-1); // 동일 원
                } else {
                    System.out.println(0); // 중심 같고 반지름 다름 (만나지 않음)
                }
            } else if (distanceSq == sumR * sumR || distanceSq == diffR * diffR) {
                System.out.println(1); // 외접 or 내접
            } else if (distanceSq > sumR * sumR || distanceSq < diffR * diffR) {
                System.out.println(0); // 만나지 않음
            } else {
                System.out.println(2); // 두 점에서 만남
            }
        }
    }
}

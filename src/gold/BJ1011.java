package gold;

import java.util.Scanner;

public class BJ1011 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt(); //테스트 갯수

        for (int i = 0; i < T; i++) {
            long x = sc.nextLong();
            long y = sc.nextLong();
            long distance = y - x;

            long n = 0;
            while (n * n <= distance) {
                n++;
            }
            n--;

            if (distance == n * n) {
                System.out.println(2 * n - 1);
            } else if (distance <= n * (n + 1)) {
                System.out.println(2 * n);
            } else {
                System.out.println(2 * n + 1);
            }
        }
    }
}

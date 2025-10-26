package gold;

import java.util.Scanner;

public class BJ11758 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int x1 = sc.nextInt();
        int y1 = sc.nextInt();

        int x2 = sc.nextInt();
        int y2 = sc.nextInt();

        int x3 = sc.nextInt();
        int y3 = sc.nextInt();

        int s = (x2 - x1) * (y3 - y1) - (y2 - y1) * (x3 - x1);

        if (s > 0) {
            System.out.println(1);
        } else if (s < 0) {
            System.out.println(-1);
        } else {
            System.out.println(0);
        }
    }
}

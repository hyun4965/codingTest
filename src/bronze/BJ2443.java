package bronze;

import java.util.Scanner;

public class BJ2443 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        for (int i = 0; i < n; i++) {
            // 공백 출력
            for (int j = 0; j < i; j++) {
                System.out.print(" ");
            }
            // 별 출력
            for (int j = 0; j < (2 * n - 1) - (2 * i); j++) {
                System.out.print("*");
            }
            // 줄 바꿈
            System.out.println();
        }
        sc.close();
    }
}

package bronze;

import java.util.Scanner;

public class BJ10162 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt(); // 요리 시간 T초

        int A = 300;
        int B = 60;
        int C = 10;

        if (T % 10 != 0) {
            System.out.println("-1");
            return;
        }

        int countA = T / A;
        T %= A;

        int countB = T / B;
        T %= B;

        int countC = T / C;

        System.out.println(countA + " " + countB + " " + countC);
    }
}

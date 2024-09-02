package silver;

import java.util.Scanner;

public class LCM2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int A = scanner.nextInt();
        int B = scanner.nextInt();

        int C = scanner.nextInt();
        int D = scanner.nextInt();

        int numerator = A * D + B * C;
        int denominator = B * D;

        int gcd = gcd(numerator, denominator);

        System.out.println((numerator / gcd) + " " + (denominator / gcd));
    }

    public static int gcd(int a, int b) {
        while (b != 0) {
            int temp = b;
            b = a % b;
            a = temp;
        }
        return a;
    }
}

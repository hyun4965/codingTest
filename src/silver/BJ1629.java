package silver;

import java.util.Scanner;

public class BJ1629 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        long A = sc.nextLong();
        long B = sc.nextLong();
        long C = sc.nextLong();
        sc.close();

        System.out.println(modularExponentiation(A, B, C));
    }

    private static long modularExponentiation(long base, long exp, long mod) {
        if (exp == 1) {
            return base % mod;
        }

        long half = modularExponentiation(base, exp / 2, mod);
        half = (half * half) % mod;

        if (exp % 2 != 0) {
            half = (half * base) % mod;
        }

        return half;
    }
}

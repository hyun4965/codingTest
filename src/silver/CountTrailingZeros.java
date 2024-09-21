package silver;

import java.util.Scanner;

public class CountTrailingZeros {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        long n = sc.nextLong();
        long m = sc.nextLong();

        long count5 = countFactors(n, 5) - countFactors(m, 5) - countFactors(n - m, 5);
        System.out.println(count5);
    }

    private static long countFactors(long x, long factor) {
        long count = 0;
        while (x > 0) {
            x /= factor;
            count += x;
        }
        return count;
    }
}

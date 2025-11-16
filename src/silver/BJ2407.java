package silver;

import java.math.BigInteger;
import java.util.Scanner;

public class BJ2407 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        BigInteger top = BigInteger.ONE;
        BigInteger bottom = BigInteger.ONE;

        for (int i = n; i > n - m; i--) {
            top = top.multiply(BigInteger.valueOf(i));
        }

        for (int i = 1; i <= m; i++) {
            bottom = bottom.multiply(BigInteger.valueOf(i));
        }

        BigInteger answer = top.divide(bottom);
        System.out.println(answer);
    }
}

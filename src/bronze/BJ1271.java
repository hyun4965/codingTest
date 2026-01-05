package bronze;

import java.math.BigInteger;
import java.util.Scanner;

public class BJ1271 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        BigInteger n = sc.nextBigInteger(); // 가진 돈
        BigInteger m = sc.nextBigInteger(); // 생명체 수

        System.out.println(n.divide(m));
        System.out.println(n.remainder(m));
    }
}

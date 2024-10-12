package bronze;

import java.util.Scanner;

public class BJ2420 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        long n = sc.nextInt();
        long m = sc.nextInt();
        System.out.println(Math.abs(n - m));
    }
}

package bronze;

import java.util.Scanner;

public class GCDAndLCM {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int a = sc.nextInt();
        int b = sc.nextInt();

        int gcd = gcd(a, b);
        int lcm = a * b / gcd;

        System.out.println(gcd);
        System.out.println(lcm);
    }

    // 유클리드 호제법을 이용한 최대공약수(GCD) 함수
    public static int gcd(int a, int b) {
        if (b == 0) {
            return a;
        }
        return gcd(b, a % b);
    }
}

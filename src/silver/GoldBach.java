package silver;

import java.util.Scanner;

public class GoldBach {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        final int MAX = 1000000;
        boolean[] isPrime = new boolean[MAX + 1];

        for (int i = 2; i <= MAX; i++) {
            isPrime[i] = true;
        }

        for (int i = 2; i * i <= MAX; i++) {
            if (isPrime[i]) {
                for (int j = i * i; j <= MAX; j += i) {
                    isPrime[j] = false;
                }
            }
        }

        while (true) {
            int n = sc.nextInt();
            if (n == 0) {
                break;
            }

            boolean found = false;
            for (int i = 3; i <= n / 2; i += 2) {
                if (isPrime[i] && isPrime[n - i]) {
                    System.out.println(n + " = " + i + " + " + (n - i));
                    found = true;
                    break;
                }
            }

            if (!found) {
                System.out.println("Goldbach's conjecture is wrong.");
            }
        }
    }
}

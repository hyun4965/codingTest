package gold;

import java.util.*;

public class BJ1644 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        if (N < 2) {
            System.out.println(0);
            return;
        }

        boolean[] isprime = new boolean[N + 1];
        for (int i = 2; i * i <= N; i++) {
            if (!isprime[i]) {
                for (int j = i * i; j <= N; j += i) {
                    isprime[j] = true;
                }
            }
        }

        int primeCount = 0;
        for (int i = 2; i <= N; i++) {
            if (!isprime[i]) {
                primeCount++;
            }
        }

        int[] primes = new int[primeCount];
        int index = 0;
        for (int i = 2; i <= N; i++) {
            if (!isprime[i]) {
                primes[index++] = i;
            }
        }

        int count = 0, start = 0, end = 0, sum = 0;
        while (true) {
            if (sum >= N) {
                if (sum == N) count++;
                sum -= primes[start++];
            } else {
                if (end == primeCount) {
                    break;
                }
                sum += primes[end++];
            }
        }

        System.out.println(count);
    }
}

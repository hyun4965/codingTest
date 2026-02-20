package news;

import java.util.*;

public class BJ1644 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        boolean[] isComposite = new boolean[n + 1];
        List<Integer> primes = new ArrayList<>();

        for (int i = 2; i <= n; i++) {
            if (!isComposite[i]) {
                primes.add(i);
                if ((long) i * i <= n) {
                    for (int j = i * i; j <= n; j += i) {
                        isComposite[j] = true;
                    }
                }
            }
        }

        int count = 0;
        int left = 0, right = 0;
        int sum = 0;

        while (true) {
            if (sum >= n) {
                if (sum == n) {
                    count++;
                }
                sum -= primes.get(left++);
            } else {
                if (right == primes.size()) {
                    break;
                }
                sum += primes.get(right++);
            }
        }

        System.out.println(count);
    }
}
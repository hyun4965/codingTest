package silver;

import java.util.*;

public class BJ1059 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int L = sc.nextInt();
        int[] S = new int[L];

        for (int i = 0; i < L; i++) {
            S[i] = sc.nextInt();
        }

        int n = sc.nextInt();

        Arrays.sort(S);

        for (int i = 0; i < L; i++) {
            if (S[i] == n) {
                System.out.println(0);
                return;
            }
        }

        // n보다 작으면서 가장 큰 수: lower
        // n보다 크면서 가장 작은 수: upper
        int lower = 0;
        int upper = 1001;

        for (int i = 0; i < L; i++) {
            if (S[i] < n) {
                lower = Math.max(lower, S[i]);
            } else if (S[i] > n) {
                upper = Math.min(upper, S[i]);
            }
        }


        int count = 0;
        for (int a = lower + 1; a <= n; a++) {
            for (int b = n; b < upper; b++) {
                if (a < b) {
                    count++;
                }
            }
        }

        System.out.println(count);
    }
}

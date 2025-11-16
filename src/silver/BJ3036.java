package silver;

import java.util.Scanner;

public class BJ3036 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();
        int[] r = new int[N];

        for (int i = 0; i < N; i++) {
            r[i] = sc.nextInt();
        }

        int first = r[0];

        for (int i = 1; i < N; i++) {
            int g = gcd(first, r[i]);
            int A = first / g;
            int B = r[i] / g;
            System.out.println(A + "/" + B);
        }
    }

    private static int gcd(int a, int b) {
        while (b != 0) {
            int tmp = a % b;
            a = b;
            b = tmp;
        }
        return a;
    }
}

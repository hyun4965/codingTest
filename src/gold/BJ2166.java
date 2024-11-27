package gold;

import java.util.Scanner;

public class BJ2166 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();

        long[] x = new long[N];
        long[] y = new long[N];

        for (int i = 0; i < N; i++) {
            x[i] = sc.nextLong();
            y[i] = sc.nextLong();
        }

        double area = 0.0;
        for (int i = 0; i < N; i++) {
            int next = (i + 1) % N;
            area += (x[i] * y[next]) - (y[i] * x[next]);
        }

        area = Math.abs(area) / 2.0;

        System.out.println(String.format("%.1f", area));
    }
}

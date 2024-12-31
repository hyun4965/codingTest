package gold;

import java.util.Scanner;

public class BJ10986 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int M = sc.nextInt();

        long[] arr = new long[M];
        long sum = 0;  // 누적 합
        long count = 0;

        for (int i = 0; i < N; i++) {
            long num = sc.nextLong();
            sum += num;
            int remainder = (int) (sum % M);

            if (remainder < 0) {
                remainder += M;
            }

            if (remainder == 0) {
                count++;
            }
            count += arr[remainder];
            arr[remainder]++;
        }

        System.out.println(count);
    }
}

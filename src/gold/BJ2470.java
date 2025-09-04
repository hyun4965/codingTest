package gold;

import java.util.Arrays;
import java.util.Scanner;

public class BJ2470 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        long[] arr = new long[N];

        for (int i = 0; i < N; i++) {
            arr[i] = sc.nextLong();
        }
        Arrays.sort(arr);


        int left = 0, right = N - 1;
        long bestSum = Long.MAX_VALUE;
        long a = 0, b = 0;

        while (left < right) {
            long sum = arr[left] + arr[right];
            if (Math.abs(sum) < Math.abs(bestSum)) {
                bestSum = sum;
                a = arr[left];
                b = arr[right];
                if (bestSum == 0) break;
            }
            if (sum > 0) right--;
            else left++;
        }

        if (a < b) {
            System.out.println(a + " " + b);
        } else {
            System.out.println(b + " " + a);
        }
    }
}

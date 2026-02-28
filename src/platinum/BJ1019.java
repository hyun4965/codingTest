package platinum;

import java.util.Scanner;

public class BJ1019 {
    static long[] count;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        long n = sc.nextLong();
        count = new long[10];

        long start = 1;
        long end = n;
        long digit = 1; // 자릿수

        while (start <= end) {
            while (start % 10 != 0 && start <= end) {
                addNumber(start, digit);
                start++;
            }

            if (start > end) {
                break;
            }

            while (end % 10 != 9 && start <= end) {
                addNumber(end, digit);
                end--;
            }

            //start 는 0, end는 9 상태일 때...
            long blockCount = (end / 10 - start / 10 + 1);
            for (int i = 0; i < 10; i++) {
                count[i] += blockCount * digit;
            }

            start /= 10;
            end /= 10;
            digit *= 10;
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < 10; i++) {
            sb.append(count[i]);
            if (i < 9) {
                sb.append(' ');
            }
        }
        System.out.print(sb);
    }

    static void addNumber(long number, long digit) {
        while (number > 0) {
            count[(int) (number % 10)] += digit;
            number /= 10;
        }
    }
}

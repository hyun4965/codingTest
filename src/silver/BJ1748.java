package silver;

import java.util.Scanner;

public class BJ1748 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        long N = sc.nextLong();

        long answer = 0;
        long start = 1;
        int digit = 1;

        while (start <= N) {
            long end = start * 10 - 1;
            if (end > N) {
                end = N;
            }

            long count = end - start + 1;
            answer += count * digit;

            start *= 10;
            digit++;
        }

        System.out.println(answer);
    }
}

package news;

import java.util.Scanner;

public class BJ1929 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int M = sc.nextInt();
        int N = sc.nextInt();

        boolean[] isPrime = new boolean[N + 1];

        isPrime[0] = true;
        isPrime[1] = true;


        for (int i = 2; i * i <= N; i++) {
            if (!isPrime[i]) {
                for (int j = i * i; j <= N; j += i) {
                    isPrime[j] = true;
                }
            }
        }

        StringBuilder sb = new StringBuilder();
        for (int i = M; i <= N; i++) {
            if (!isPrime[i]) {
                sb.append(i).append('\n');
            }
        }
        System.out.println(sb);
    }
}
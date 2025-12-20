package news;

import java.util.Arrays;
import java.util.Scanner;

public class BJ1026 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int sum = 0;

        int[] a = new int[n];
        int[] b = new int[n];

        for(int i = 0; i < n; i++) {
            a[i] = sc.nextInt();
        }
        for(int i = 0; i < n; i++) {
            b[i] = sc.nextInt();
        }

        Arrays.sort(a);
        Arrays.sort(b);

        for(int i = 0; i < n; i++) {
            sum += a[i] * b[n-1-i];
        }
        System.out.println(sum);
    }
}

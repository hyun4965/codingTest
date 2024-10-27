package bronze;

import java.util.Scanner;

public class BJ3046 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int avg = sc.nextInt();
        System.out.println(2*avg - n);
    }
}

package bronze;

import java.util.Scanner;

public class BJ2163 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int M = sc.nextInt();
        int answer = M*N-1;

        System.out.println(answer);
    }
}

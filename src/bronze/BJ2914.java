package bronze;

import java.util.Scanner;

public class BJ2914 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int A = sc.nextInt(); //수록곡 갯수
        int I = sc.nextInt(); //평균값
        System.out.print(A * (I-1) + 1);
    }
}

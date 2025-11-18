package news;

import java.util.Scanner;

public class BJ31403 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String A = sc.next();
        String B = sc.next();
        String C = sc.next();

        int numA = Integer.parseInt(A);
        int numB = Integer.parseInt(B);
        int numC = Integer.parseInt(C);
        int result1 = numA + numB - numC;

        String concat = A + B;
        int result2 = Integer.parseInt(concat) - numC;

        System.out.println(result1);
        System.out.println(result2);
    }
}

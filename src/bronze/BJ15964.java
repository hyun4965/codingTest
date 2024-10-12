package bronze;

import java.util.Scanner;

public class BJ15964 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int A = sc.nextInt();
        int B = sc.nextInt();
        int result = (A+B) * (A-B);
        System.out.println(result);
    }
}

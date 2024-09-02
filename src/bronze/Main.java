package bronze;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();

        for (int i = 0; i < N; i++) {
            int A = sc.nextInt();
            int B = sc.nextInt();

            int lcm = Math.min(A, B);
            while (true) {
                if (lcm % A == 0 && lcm % B == 0) {
                    System.out.println(lcm);
                    break;
                }
                lcm++;
            }
        }
    }
}
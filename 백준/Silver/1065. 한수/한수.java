import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        System.out.print(countHansu(n));
        
    }
    static int countHansu(int n) {
        if (n < 100) {
            return n;
        }

        int cnt = 99;

        if (n == 1000) {
            n = 999;
        }

        for (int i = 100; i <= n; i++) {
            int hun = i / 100;
            int ten = (i / 10) % 10;
            int one = i % 10;

            if ((hun - ten) == (ten - one)) {
                cnt++;
            }
        }

        return cnt;
    }
}
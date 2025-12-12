import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        long[] p = new long[101];
        p[1] = 1;
        p[2] = 1;
        p[3] = 1;

        for (int i = 4; i <= 100; i++) {
            p[i] = p[i - 2] + p[i - 3];
        }

        int t = sc.nextInt();//테스트 케이스 갯수
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < t; i++) {
            int n = sc.nextInt();
            sb.append(p[n]).append('\n');
        }

        System.out.print(sb.toString());
    }
}

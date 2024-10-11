package bronze;

import java.util.Scanner;

import java.util.Scanner;

public class BJ2775 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int T = sc.nextInt();

        for (int t = 0; t < T; t++) {
            int k = sc.nextInt();  // 층수 입력
            int n = sc.nextInt();  // 호수 입력

            int[][] apt = new int[k + 1][n + 1];

            for (int i = 1; i <= n; i++) {
                apt[0][i] = i;
            }

            for (int i = 1; i <= k; i++) {
                for (int j = 1; j <= n; j++) {
                    apt[i][j] = apt[i][j - 1] + apt[i - 1][j];
                }
            }
            System.out.println(apt[k][n]);
        }
        sc.close();
    }
}

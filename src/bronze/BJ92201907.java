package bronze;

import java.util.Scanner;

public class BJ92201907 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();
        int D = sc.nextInt();
        int K = sc.nextInt();
        int[] fallingStar = new int[N];

        for (int i = 0; i < N; i++) {
            fallingStar[i] = sc.nextInt();
        }

        int[] stars = new int[N];
        int Count = 0;

        for (int day = 0; day < D; day++) {
            boolean needClean = false;

            for (int i = 0; i < N; i++) {
                if (stars[i] + fallingStar[i] > K) {
                    needClean = true;
                    break;
                }
            }

            if (needClean) {
                for (int i = 0; i < N; i++) {
                    stars[i] = 0;
                }
                Count++;
            }

            for (int i = 0; i < N; i++) {
                stars[i] += fallingStar[i];
            }
        }
        System.out.println(Count);
    }
}

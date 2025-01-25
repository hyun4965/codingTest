package gold;

import java.util.Scanner;

public class BJ2096 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();
        int[] maxDp = new int[3];
        int[] minDp = new int[3];

        for (int i = 0; i < N; i++) {
            int x1 = sc.nextInt();
            int x2 = sc.nextInt();
            int x3 = sc.nextInt();

            if (i == 0) {
                maxDp[0] = minDp[0] = x1;
                maxDp[1] = minDp[1] = x2;
                maxDp[2] = minDp[2] = x3;
            } else {
                int prevMax0 = maxDp[0];
                int prevMax1 = maxDp[1];
                int prevMax2 = maxDp[2];
                maxDp[0] = Math.max(prevMax0, prevMax1) + x1;
                maxDp[2] = Math.max(prevMax1, prevMax2) + x3;
                maxDp[1] = Math.max(Math.max(prevMax0, prevMax1), prevMax2) + x2;

                int prevMin0 = minDp[0];
                int prevMin1 = minDp[1];
                int prevMin2 = minDp[2];
                minDp[0] = Math.min(prevMin0, prevMin1) + x1;
                minDp[2] = Math.min(prevMin1, prevMin2) + x3;
                minDp[1] = Math.min(Math.min(prevMin0, prevMin1), prevMin2) + x2;
            }
        }

        System.out.println(Math.max(maxDp[0], Math.max(maxDp[1], maxDp[2])) + " " + Math.min(minDp[0], Math.min(minDp[1], minDp[2])));

    }
}
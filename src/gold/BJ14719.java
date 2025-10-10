package gold;

import java.util.Scanner;

public class BJ14719 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int H = sc.nextInt(); //높이
        int W = sc.nextInt(); //가로

        int[] land = new int[W];

        for (int i = 0; i < W; i++) {
            land[i] = sc.nextInt();
        }

        int result = 0;

        for (int i = 1; i < W - 1; i++) {
            int leftMax = 0;
            int rightMax = 0;

            for (int l = 0; l < i; l++) {
                leftMax = Math.max(leftMax, land[l]);
            }

            for (int r = i + 1; r < W; r++) {
                rightMax = Math.max(rightMax, land[r]);
            }

            int water = Math.min(leftMax, rightMax) - land[i];
            if (water > 0) {
                result += water;
            }
        }
        System.out.println(result);
    }
}

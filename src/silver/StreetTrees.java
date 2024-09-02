package silver;

import java.util.Scanner;

public class StreetTrees {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int[] arr = new int[N];
        for (int i = 0; i < N; i++) {
            arr[i] = sc.nextInt();
        }
        int[] gap = new int[N - 1];
        for (int i = 1; i < N; i++) {
            gap[i - 1] = arr[i] - arr[i - 1];
        }

        int gcd = gap[0];
        for (int i = 1; i < gap.length; i++) {
            gcd = findGCD(gcd, gap[i]);
        }

        int tree = 0;
        for (int num : gap) {
            int numOfIntervals = (num / gcd) - 1;
            tree += numOfIntervals;
        }
        System.out.println(tree);
    }

    private static int findGCD(int a, int b) {
        while (b != 0) {
            int temp = b;
            b = a % b;
            a = temp;
        }
        return a;
    }
}

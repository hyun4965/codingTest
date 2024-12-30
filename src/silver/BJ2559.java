package silver;

import java.util.Scanner;

public class BJ2559 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int k = sc.nextInt();
        int[] temp = new int[n];
        for (int i = 0; i < n; i++) {
            temp[i] = sc.nextInt();
        }
        System.out.println(findByseries(temp,n,k));
    }
    static int findByseries(int[] temp, int n, int k) {
        int maxSum = Integer.MIN_VALUE;
        int currentSum = 0;
        for (int i = 0; i < k; i++) {
            currentSum += temp[i];
        }

        maxSum = currentSum;

        for (int i = k; i < n; i++) {
            currentSum = currentSum - temp[i - k] + temp[i];
            maxSum = Math.max(maxSum, currentSum);
        }
        return maxSum;
    }
}

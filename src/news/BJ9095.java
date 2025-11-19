package news;

import java.util.Scanner;

public class BJ9095 {
    static int count = 0;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        for(int i=0; i<n; i++) {
            int num = sc.nextInt();
            count = 0;
            dfs(0, num);
            System.out.println(count);
        }
    }
    static void dfs(int currentSum, int target) {
        if (currentSum > target) {
            return;
        }
        if (currentSum == target) {
            count++;
            return;
        }

        dfs(currentSum + 1, target);
        dfs(currentSum + 2, target);
        dfs(currentSum + 3, target);
    }
}

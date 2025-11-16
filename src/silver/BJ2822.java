package silver;

import java.util.Arrays;
import java.util.Scanner;

public class BJ2822 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int[][] arr = new int[8][2];

        for (int i = 0; i < 8; i++) {
            arr[i][0] = sc.nextInt();
            arr[i][1] = i + 1;
        }

        Arrays.sort(arr, (a, b) -> b[0] - a[0]);

        int sum = 0;
        int[] nums = new int[5];

        for (int i = 0; i < 5; i++) {
            sum += arr[i][0];
            nums[i] = arr[i][1];
        }

        Arrays.sort(nums);

        System.out.println(sum);
        for (int x : nums) {
            System.out.print(x + " ");
        }
    }
}

package silver;

import java.util.Arrays;
import java.util.Scanner;

public class BJ1920 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();
        int[] arr = new int[N];
        for (int i = 0; i < N; i++) {
            arr[i] = sc.nextInt();
        }

        Arrays.sort(arr);

        int M = sc.nextInt();
        for (int i = 0; i < M; i++) {
            int target = sc.nextInt();
            if (binarySearch(arr, target)) {
                System.out.println(1);  // 존재하면 1 출력
            } else {
                System.out.println(0);  // 존재하지 않으면 0 출력
            }
        }
    }

    public static boolean binarySearch(int[] arr, int target) {
        int left = 0;
        int right = arr.length - 1;

        while (left <= right) {
            int mid = (left + right) / 2;

            if (arr[mid] == target) {
                return true;
            } else if (arr[mid] < target) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }

        return false;
    }
}

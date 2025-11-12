package gold;

import java.util.*;

public class BJ2343 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt(); // 강의 수
        int m = sc.nextInt(); // 블루레이 수

        int[] lessons = new int[n];
        for (int i = 0; i < n; i++) {
            lessons[i] = sc.nextInt();
        }

        int left = 0;
        int right = 0;
        for (int len : lessons) {
            left = Math.max(left, len); // 가장 긴 강의 9
            right += len; //전체 합 45
        }

        int result = right;
        while (left <= right) {
            int mid = (left + right) / 2;

            int count = countBluRay(lessons, mid);

            if (count <= m) {
                result = mid; //가능
                right = mid - 1;
            } else {
                left = mid + 1; // 불가능
            }
        }

        System.out.println(result);
    }

    static int countBluRay(int[] arr, int size) {
        int count = 1;
        int sum = 0;

        for (int x : arr) {
            if (sum + x > size) {
                count++;
                sum = x;
            } else {
                sum += x;
            }
        }
        return count;
    }
}

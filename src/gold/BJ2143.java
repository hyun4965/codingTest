package gold;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class BJ2143 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        long t = sc.nextLong();

        int n = sc.nextInt();
        int[] arrN = new int[n];
        for (int i = 0; i < n; i++) {
            arrN[i] = sc.nextInt();
        }

        int m = sc.nextInt();
        int[] arrM = new int[m];
        for (int i = 0; i < m; i++) {
            arrM[i] = sc.nextInt();
        }

        List<Long> subA = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            long sum = 0;
            for (int j = i; j < n; j++) {
                sum += arrN[j];
                subA.add(sum);
            }
        }

        List<Long> subB = new ArrayList<>();
        for (int i = 0; i < m; i++) {
            long sum = 0;
            for (int j = i; j < m; j++) {
                sum += arrM[j];
                subB.add(sum);
            }
        }

        Collections.sort(subB);

        long count = 0;
        for (long sumA : subA) {
            long target = t - sumA;
            count += upperBound(subB, target) - lowerBound(subB, target);
        }

        System.out.print(count);
    }

    //이분탐색
    private static int lowerBound(List<Long> arr, long target) {
        int left = 0;
        int right = arr.size();
        while (left < right) {
            int mid = (left + right) / 2;
            if (arr.get(mid) >= target) {
                right = mid;
            } else {
                left = mid + 1;
            }
        }
        return right;
    }

    //이분탐색
    private static int upperBound(List<Long> arr, long target) {
        int left = 0;
        int right = arr.size();
        while (left < right) {
            int mid = (left + right) / 2;
            if (arr.get(mid) > target) {
                right = mid;
            } else {
                left = mid + 1;
            }
        }
        return right;
    }
}

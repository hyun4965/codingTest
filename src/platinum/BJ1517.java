package platinum;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class BJ1517 {
    static int N;
    static long[] arr;
    static long[] tree;
    static long count = 0;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        N = sc.nextInt();
        arr = new long[N];
        for (int i = 0; i < N; i++) {
            arr[i] = sc.nextInt();
        }
        tree = new long[N];

        mergeSort(0, N - 1);
        System.out.print(count);
    }

    static void mergeSort(int left, int right) {
        if (left >= right) {
            return;
        }

        int mid = (left + right) / 2;
        //분할 정복.
        mergeSort(left, mid);
        mergeSort(mid + 1, right);

        //merge 하자.
        merge(left, mid, right);
    }

    static void merge(int left, int mid, int right) {
        int i = left;
        int j = mid + 1;
        int k = left;

        while (i <= mid && j <= right) {
            if (arr[i] <= arr[j]) {
                tree[k++] = arr[i++];
            } else {
                tree[k++] = arr[j++];
                count += (mid - i + 1);
            }
        }

        while (i <= mid) {
            tree[k++] = arr[i++];
        }
        while (j <= right) {
            tree[k++] = arr[j++];
        }

        for (int index = left; index <= right; index++) {
            arr[index] = tree[index];
        }
    }
}
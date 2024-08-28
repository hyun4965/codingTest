package silver;

import java.util.Arrays;
import java.util.Scanner;

public class NumberCardGame {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        //N 입력받기
        int N = sc.nextInt();
        int[] arr = new int[N];
        for (int i = 0; i < N; i++) {
            arr[i] = sc.nextInt();
        }
        //이진 탐색 트리 사용하기 위해 정렬
        Arrays.sort(arr);

        //M 입력받기
        int M = sc.nextInt();
        int[] arr2 = new int[M];
        for (int i = 0; i < M; i++) {
            arr2[i] = sc.nextInt();
        }

        // 이진 탐색트리를 통해 찾기
        for (int i = 0; i < M; i++) {
            int key = arr2[i];
            boolean found = false;

            for (int left = 0, right = N - 1; left <= right; ) {
                int mid = (left + right) / 2;

                if (arr[mid] == key) {
                    found = true;
                    break;
                } else if (arr[mid] < key) {
                    left = mid + 1;
                } else {
                    right = mid - 1;
                }
            }

            if (found) {
                System.out.print("1 ");
            } else {
                System.out.print("0 ");
            }
        }
    }
}

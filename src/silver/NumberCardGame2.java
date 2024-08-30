package silver;

import java.util.Arrays;
import java.util.Scanner;

public class NumberCardGame2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // N 입력받기
        int N = sc.nextInt();
        int[] arr = new int[N];
        for (int i = 0; i < N; i++) {
            arr[i] = sc.nextInt();
        }
        // 이진 탐색 트리 사용하기 위해 정렬
        Arrays.sort(arr);

        // M 입력받기
        int M = sc.nextInt();
        int[] arr2 = new int[M];
        for (int i = 0; i < M; i++) {
            arr2[i] = sc.nextInt();
        }

        // 이진 탐색을 통한 숫자 카드 개수 찾기
        for (int i = 0; i < M; i++) {
            int key = arr2[i];

            int left = 0;
            int right = N;
            while (left < right) {
                int mid = (left + right) / 2;
                if (arr[mid] < key) {
                    left = mid + 1;
                } else {
                    right = mid;
                }
            }
            int lowerBound = left;

            left = 0;
            right = N;
            while (left < right) {
                int mid = (left + right) / 2;
                if (arr[mid] <= key) {
                    left = mid + 1;
                } else {
                    right = mid;
                }
            }
            int upperBound = left;

            // 숫자의 개수는 upperBound - lowerBound
            int count = upperBound - lowerBound;

            // 결과 출력
            System.out.print(count + " ");
        }
    }
}

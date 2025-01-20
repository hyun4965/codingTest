package silver;

import java.util.Arrays;
import java.util.Scanner;

public class BJ6603 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (true) {
            int n = sc.nextInt();
            // 0일시 종료
            if (n == 0) {
                break;
            }
            int[] arr = new int[n];
            for (int i = 0; i < n; i++) {
                arr[i] = sc.nextInt();
            }
            Arrays.sort(arr);
            int[] combination = new int[6];
            backtracking(arr, combination, 0, 0);
            System.out.println();
        }
    }

    private static void backtracking(int[] arr, int[] combination, int start, int depth) {
        if (depth == 6) { // 6개를 선택하면 출력
            for (int num : combination) {
                System.out.print(num + " ");
            }
            System.out.println();
            return;
        }

        for (int i = start; i < arr.length; i++) {
            combination[depth] = arr[i];
            backtracking(arr, combination, i + 1, depth + 1);
        }
    }
}

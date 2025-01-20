package silver;

import java.util.Scanner;

public class BJ1182 {
    static int count = 0;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int S = sc.nextInt();
        int[] arr = new int[N];

        for (int i = 0; i < N; i++) {
            arr[i] = sc.nextInt();
        }

        backtracking(arr, S, 0, 0);

        if (S == 0) {
            count--;
        }

        System.out.println(count);
    }

    public static void backtracking(int[] arr, int S, int index, int currentSum) {
        if (index == arr.length) {
            if (currentSum == S) {
                count++;
            }
            return;
        }

        // 현재 인덱스의 원소를 선택하지 않는 경우
        backtracking(arr, S, index + 1, currentSum);

        // 현재 인덱스의 원소를 선택하는 경우
        backtracking(arr, S, index + 1, currentSum + arr[index]);
    }
}

package silver;

import java.util.Scanner;

import java.util.Arrays;

public class BJ15657 {
    static int N, M;
    static int[] numbers;
    static int[] sequence;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        N = sc.nextInt();
        M = sc.nextInt();
        numbers = new int[N];
        sequence = new int[M];

        for (int i = 0; i < N; i++) {
            numbers[i] = sc.nextInt();
        }

        Arrays.sort(numbers);
        dfs(0, 0);
    }

    static void dfs(int depth, int start) {
        if (depth == M) {
            for (int i = 0; i < M; i++) {
                System.out.print(sequence[i] + " ");
            }
            System.out.println();
            return;
        }

        for (int i = start; i < N; i++) {
            sequence[depth] = numbers[i];
            dfs(depth + 1, i);
        }
    }
}

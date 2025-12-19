package news;

import java.util.Scanner;

public class BJ15652 {
    static int N, M;
    static int[] arr;
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        M = sc.nextInt();

        arr = new int[M];
        dfs(0, 1);

        System.out.print(sb.toString());
    }

    public static void dfs(int depth, int start) {
        if (depth == M) {
            for (int i = 0; i < M; i++) {
                sb.append(arr[i]).append(i == M - 1 ? '\n' : ' ');
            }
            return;
        }

        for (int i = start; i <= N; i++) {
            arr[depth] = i;
            dfs(depth + 1, i);
        }
    }
}

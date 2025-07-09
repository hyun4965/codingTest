package silver;

import java.util.Arrays;
import java.util.Scanner;

public class BJ15655 {
    static int N, M;
    static int[] arr, result;
    static boolean[] visited;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        N = sc.nextInt();
        M = sc.nextInt();

        arr = new int[N];
        result = new int[M];

        for(int i = 0; i < N; i++) {
            arr[i] = sc.nextInt();
        }

        Arrays.sort(arr);

        dfs(0, 0);
    }

    static void dfs(int start, int depth) {
        if(depth == M) {
            for(int i = 0; i < M; i++) {
                System.out.print(result[i] + " ");
            }
            System.out.println();
            return;
        }

        for(int i = start; i < N; i++) {
            result[depth] = arr[i];
            dfs(i + 1, depth + 1);
        }
    }
}

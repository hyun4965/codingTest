package silver;

import java.util.*;

public class BJ10974{
    static int[] arr;
    static boolean[] visited;
    static int n;

    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        arr = new int[n];
        visited = new boolean[n+1];

        backtrack(0);


    }
    public static void backtrack(int depth){
        if (depth == n) {
            for (int val : arr) {
                System.out.print(val + " ");
            }
            System.out.println();
            return;
        }

        for (int i = 1; i <= n; i++) {
            if (!visited[i]) {
                visited[i] = true;
                arr[depth] = i;
                backtrack(depth + 1);
                visited[i] = false;
            }
        }
    }
}
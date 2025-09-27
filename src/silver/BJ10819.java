package silver;

import  java.util.*;

public class BJ10819 {
    static int N;
    static int[] A, pick;
    static boolean[] used;
    static int best = Integer.MIN_VALUE;

    static void dfs(int depth) {
        if (depth == N) {
            int s = 0;
            for (int i = 1; i < N; i++) s += Math.abs(pick[i - 1] - pick[i]);
            if (s > best) best = s;
            return;
        }
        for (int i = 0; i < N; i++) {
            if (used[i]) continue;
            used[i] = true;
            pick[depth] = A[i];
            dfs(depth + 1);
            used[i] = false;
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        A = new int[N];
        for (int i = 0; i < N; i++) A[i] = sc.nextInt();

        used = new boolean[N];
        pick = new int[N];
        dfs(0);

        System.out.println(best);
    }
}

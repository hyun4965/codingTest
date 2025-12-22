import java.util.Scanner;

public class Main {
    static int N;
    static int[] A;
    static int[] op = new int[4];
    static int maxVal = Integer.MIN_VALUE;
    static int minVal = Integer.MAX_VALUE;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        N = sc.nextInt();
        A = new int[N];
        for (int i = 0; i < N; i++) {
            A[i] = sc.nextInt();
        }

        for (int i = 0; i < 4; i++) {
            op[i] = sc.nextInt();
        }

        dfs(1, A[0]);
        System.out.println(maxVal);
        System.out.println(minVal);
    }

    static void dfs(int idx, int cur) {
        if (idx == N) {
            maxVal = Math.max(maxVal, cur);
            minVal = Math.min(minVal, cur);
            return;
        }

        int next = A[idx];

        if (op[0] > 0) {
            op[0]--;
            dfs(idx + 1, cur + next);
            op[0]++;
        }

        if (op[1] > 0) {
            op[1]--;
            dfs(idx + 1, cur - next);
            op[1]++;
        }

        if (op[2] > 0) {
            op[2]--;
            dfs(idx + 1, cur * next);
            op[2]++;
        }

        if (op[3] > 0) {
            op[3]--;
            dfs(idx + 1, cur / next);
            op[3]++;
        }
    }
}

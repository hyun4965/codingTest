package silver;

import java.util.Scanner;

public class NandM {
    static int n, m;
    static int[] s;
    static boolean[] visited;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        m = sc.nextInt();

        s = new int[m];
        visited = new boolean[n + 1];
        def(0);
    }

    static void def(int depth) {
        if (depth == m) {
            for (int i = 0; i < m; i++) {
                System.out.print(s[i] + " ");
            }
            System.out.println();
            return;
        }
        for (int i = 1; i <= n; i++) {
            if (!visited[i]) {
                visited[i] = true;
                s[depth] = i;
                def(depth + 1);
                visited[i] = false;
            }
        }
    }
}

package gold;

import java.util.*;

public class BJ3665 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        StringBuilder out = new StringBuilder();
        int T = sc.nextInt();

        while (T-- > 0) {
            int n = sc.nextInt();
            int[] last = new int[n]; //이전 대회 순위
            for (int i = 0; i < n; i++) {
                last[i] = sc.nextInt();
            }

            boolean[][] adj = new boolean[n + 1][n + 1];
            int[] indeg = new int[n + 1];

            for (int i = 0; i < n; i++) {
                int higher = last[i];
                for (int j = i + 1; j < n; j++) {
                    int lower = last[j];
                    if (!adj[higher][lower]) {
                        adj[higher][lower] = true;
                        indeg[lower]++;
                    }
                }
            }

            int m = sc.nextInt();
            for (int i = 0; i < m; i++) {
                int a = sc.nextInt();
                int b = sc.nextInt();

                if (adj[a][b]) {
                    adj[a][b] = false;
                    indeg[b]--;
                    adj[b][a] = true;
                    indeg[a]++;
                } else if (adj[b][a]) {
                    adj[b][a] = false;
                    indeg[a]--;
                    adj[a][b] = true;
                    indeg[b]++;
                }
            }

            Queue<Integer> q = new ArrayDeque<>();
            for (int i = 1; i <= n; i++) if (indeg[i] == 0) q.offer(i);

            boolean ambiguous = false;
            int picked = 0;
            int[] ans = new int[n];

            for (int i = 0; i < n; i++) {
                if (q.isEmpty()) {
                    out.append("IMPOSSIBLE\n");
                    picked = -1;
                    break;
                }
                if (q.size() > 1) {
                    ambiguous = true;
                }

                int cur = q.poll();
                ans[i] = cur;
                picked++;

                for (int v = 1; v <= n; v++) {
                    if (adj[cur][v]) {
                        indeg[v]--;
                        if (indeg[v] == 0) q.offer(v);
                    }
                }
            }

            if (picked == -1) {
                continue;
            } else if (ambiguous) {
                out.append("?\n");
            } else {
                for (int i = 0; i < n; i++) {
                    if (i > 0) out.append(' ');
                    out.append(ans[i]);
                }
                out.append('\n');
            }
        }

        System.out.print(out.toString());


    }
}

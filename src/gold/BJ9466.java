package gold;

import java.io.*;
import java.util.*;

public class BJ9466 {

    static int n;
    static int[] pick;
    static boolean[] visited, finished;
    static int teamCount;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int T = Integer.parseInt(br.readLine());

        while (T-- > 0) {
            n = Integer.parseInt(br.readLine());

            pick = new int[n + 1];
            visited = new boolean[n + 1];
            finished = new boolean[n + 1];
            teamCount = 0;

            StringTokenizer st = new StringTokenizer(br.readLine());

            for (int i = 1; i <= n; i++) {
                pick[i] = Integer.parseInt(st.nextToken());
            }

            for (int i = 1; i <= n; i++) {
                if (!visited[i]) {
                    dfs(i);
                }
            }

            sb.append(n - teamCount).append('\n');
        }

        System.out.print(sb);
    }

    static void dfs(int cur) {
        visited[cur] = true;
        int next = pick[cur];

        if (!visited[next]) {
            dfs(next);
        } else {
            if (!finished[next]) {
                int cnt = 1;
                for (int i = next; i != cur; i = pick[i]) {
                    cnt++;
                }
                teamCount += cnt;
            }
        }

        finished[cur] = true;
    }
}

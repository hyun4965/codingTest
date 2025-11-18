package gold;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class BJ1005 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int t = Integer.parseInt(br.readLine());

        while (t-- > 0) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(st.nextToken());
            int k = Integer.parseInt(st.nextToken());

            int[] buildTimes = new int[n + 1];
            List<Integer>[] list = new ArrayList[n + 1];
            int[] inDegree = new int[n + 1];

            st = new StringTokenizer(br.readLine());
            for (int i = 1; i <= n; i++) {
                buildTimes[i] = Integer.parseInt(st.nextToken());
                list[i] = new ArrayList<>();
            }

            for (int i = 0; i < k; i++) {
                st = new StringTokenizer(br.readLine());
                int x = Integer.parseInt(st.nextToken());
                int y = Integer.parseInt(st.nextToken());
                list[x].add(y);
                inDegree[y]++;
            }

            int w = Integer.parseInt(br.readLine());

            int[] dp = new int[n + 1];
            Queue<Integer> queue = new LinkedList<>();

            for (int i = 1; i <= n; i++) {
                if (inDegree[i] == 0) {
                    queue.offer(i);
                    dp[i] = buildTimes[i];
                }
            }

            // 위상 정렬 진행
            while (!queue.isEmpty()) {
                int current = queue.poll();

                for (int next : list[current]) {
                    dp[next] = Math.max(dp[next], dp[current] + buildTimes[next]);
                    inDegree[next]--;

                    if (inDegree[next] == 0) {
                        queue.offer(next);
                    }
                }
            }
            sb.append(dp[w]).append('\n');
        }
        System.out.print(sb.toString());
    }
}

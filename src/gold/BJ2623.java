package gold;

import java.io.*;
import java.util.*;

public class BJ2623 {
    public static void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken()); // 가수 수
        int M = Integer.parseInt(st.nextToken()); // 보조 PD 수

        List<List<Integer>> graph = new ArrayList<>();
        for (int i = 0; i <= N; i++) {
            graph.add(new ArrayList<>());
        }

        int[] count = new int[N + 1];

        // 보조 PD들의 부분 순서 -> 인접한 쌍을 간선으로 연결
        for (int m = 0; m < M; m++) {
            st = new StringTokenizer(br.readLine());
            int k = Integer.parseInt(st.nextToken());
            if (k == 0) {
                continue; // 담당 가수 없음
            }
            int prev = Integer.parseInt(st.nextToken());
            for (int i = 1; i < k; i++) {
                int cur = Integer.parseInt(st.nextToken());
                graph.get(prev).add(cur);
                count[cur]++;
                prev = cur;
            }
        }

        Queue<Integer> queue = new ArrayDeque<>();
        for (int i = 1; i <= N; i++) {
            if (count[i] == 0) {
                queue.offer(i);
            }
        }

        StringBuilder sb = new StringBuilder();
        int picked = 0;

        while (!queue.isEmpty()) {
            int x = queue.poll();
            sb.append(x).append('\n');
            picked++;
            for (int nx : graph.get(x)) {
                if (--count[nx] == 0) {
                    queue.offer(nx);
                }
            }
        }

        if (picked != N) {
            System.out.println(0);
        } else {
            System.out.print(sb.toString());
        }
    }
}

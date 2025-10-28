package gold;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class BJ1976 {

    static int n, m;
    static List<List<Integer>> graph;
    static int[] plan; // 여행 계획

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine()); // 도시의 수
        m = Integer.parseInt(br.readLine()); // 여행계획에 속한 도시들의 수

        graph = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            graph.add(new ArrayList<>());
        }

        StringTokenizer st;
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++) {
                int connected = Integer.parseInt(st.nextToken());
                if (connected == 1) {
                    graph.get(i).add(j);
                }
            }
        }

        plan = new int[m];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < m; i++) {
            plan[i] = Integer.parseInt(st.nextToken()) - 1;
        }
        for (int i = 0; i < m - 1; i++) {
            int start = plan[i];
            int end = plan[i + 1];

            if (start == end) {
                continue;
            }

            if (!bfs(start, end)) {
                System.out.println("NO");
                return;
            }
        }

        System.out.println("YES");
    }


    private static boolean bfs(int start, int end) {
        Queue<Integer> queue = new LinkedList<>();
        boolean[] visited = new boolean[n];

        queue.add(start);
        visited[start] = true;

        while (!queue.isEmpty()) {
            int current = queue.poll();

            if (current == end) {
                return true;
            }

            for (int next : graph.get(current)) {
                if (!visited[next]) {
                    visited[next] = true;
                    queue.add(next);
                }
            }
        }

        return false;
    }
}

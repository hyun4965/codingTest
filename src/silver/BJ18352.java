package silver;

import java.util.*;

public class BJ18352 {
    static int N, M, K, X;
    static ArrayList<ArrayList<Integer>> graph = new ArrayList<>();
    static int[] dist;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        N = sc.nextInt(); // 도시의 개수
        M = sc.nextInt(); // 도로의 개수
        K = sc.nextInt(); // 거리 정보 (목표 거리)
        X = sc.nextInt(); // 출발 도시

        dist = new int[N + 1];
        for (int i = 0; i <= N; i++) {
            graph.add(new ArrayList<>());
            dist[i] = -1;
        }

        for (int i = 0; i < M; i++) {
            int a = sc.nextInt();
            int b = sc.nextInt();
            graph.get(a).add(b);
        }

        bfs(X);

        boolean found = false;
        StringBuilder sb = new StringBuilder();

        for (int i = 1; i <= N; i++) {
            if (dist[i] == K) {
                sb.append(i).append('\n');
                found = true;
            }
        }

        if (!found) {
            System.out.println("-1");
        } else {
            System.out.println(sb);
        }
    }

    static void bfs(int start) {
        Queue<Integer> q = new LinkedList<>();
        q.add(start);
        dist[start] = 0;

        while (!q.isEmpty()) {
            int now = q.poll();

            for (int next : graph.get(now)) {
                if (dist[next] == -1) {
                    dist[next] = dist[now] + 1;
                    q.add(next);
                }
            }
        }
    }
}
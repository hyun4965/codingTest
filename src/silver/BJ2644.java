package silver;

import java.util.*;

public class BJ2644 {
    static List<Integer>[] graph;
    static boolean[] visited;
    static int[] distance;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt(); //인원 수
        int start = sc.nextInt();
        int end = sc.nextInt();
        int m = sc.nextInt(); // 관계 갯수

        graph = new ArrayList[n + 1];
        for (int i = 1; i <= n; i++) {
            graph[i] = new ArrayList<>();
        }

        for (int i = 0; i < m; i++) {
            int parent = sc.nextInt();
            int child = sc.nextInt();
            graph[parent].add(child);
            graph[child].add(parent);
        }

        visited = new boolean[n + 1];
        distance = new int[n + 1];

        bfs(start);

        if (distance[end] == 0) {
            System.out.println(-1);
        } else {
            System.out.println(distance[end]);
        }
    }

    static void bfs(int start) {
        Queue<Integer> queue = new LinkedList<>();
        visited[start] = true;
        queue.offer(start);

        while (!queue.isEmpty()) {
            int current = queue.poll();

            for (int next : graph[current]) {
                if (!visited[next]) {
                    visited[next] = true;
                    distance[next] = distance[current] + 1;
                    queue.offer(next);
                }
            }
        }
    }
}

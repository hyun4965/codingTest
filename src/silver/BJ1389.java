package silver;

import java.util.*;

public class BJ1389 {
    static ArrayList<Integer>[] graph; // 인접 리스트로 그래프를 표현
    static int N, M;  // 유저와 친구 관계의 개수

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        N = sc.nextInt();
        M = sc.nextInt();

        graph = new ArrayList[N + 1];

        // 인접 리스트 초기화
        for (int i = 1; i <= N; i++) {
            graph[i] = new ArrayList<>();
        }

        // 친구 관계 입력
        for (int i = 0; i < M; i++) {
            int u = sc.nextInt();
            int v = sc.nextInt();
            graph[u].add(v);
            graph[v].add(u);
        }
        //큰값 삽입
        int minKevinBacon = Integer.MAX_VALUE;
        int person = 1;

        // 각 유저에 대해 케빈 베이컨 수 계산
        for (int i = 1; i <= N; i++) {
            int kevinBaconSum = bfs(i);
            if (kevinBaconSum < minKevinBacon) {
                minKevinBacon = kevinBaconSum;
                person = i;
            }
        }

        System.out.println(person);
    }

    // 거리합 bfs로 구하기
    static int bfs(int start) {
        Queue<Integer> queue = new LinkedList<>();
        boolean[] visited = new boolean[N + 1];
        int[] distance = new int[N + 1];

        queue.add(start);
        visited[start] = true;

        int sum = 0;

        while (!queue.isEmpty()) {
            int current = queue.poll();

            for (int i : graph[current]) {
                if (!visited[i]) {
                    visited[i] = true;
                    distance[i] = distance[current] + 1;
                    sum += distance[i];
                    queue.add(i);
                }
            }
        }

        return sum; 
    }
}

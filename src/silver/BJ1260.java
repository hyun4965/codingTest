package silver;

import java.util.*;

public class BJ1260 {
    static boolean[] visited; // 방문 여부를 체크할 배열
    static ArrayList<Integer>[] graph; // 인접 리스트로 그래프를 표현

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt(); // 노드의 개수
        int M = sc.nextInt(); // 간선의 개수
        int V = sc.nextInt(); // 탐색을 시작할 정점의 번호
        graph = new ArrayList[N + 1]; // 정점 번호는 1번부터 시작하므로 N+1 크기로 선언

        // 그래프 초기화
        for (int i = 1; i <= N; i++) {
            graph[i] = new ArrayList<>();
        }

        // 간선 입력 (양방향)
        for (int i = 0; i < M; i++) {
            int u = sc.nextInt(); // 정점 u
            int v = sc.nextInt(); // 정점 v
            graph[u].add(v);
            graph[v].add(u);
        }

        // 정점 번호가 작은 순서대로 방문하기 위해 sort
        for (int i = 1; i <= N; i++) {
            Collections.sort(graph[i]);
        }

        // DFS
        visited = new boolean[N + 1];
        dfs(V);
        System.out.println();

        // BFS 수행
        visited = new boolean[N + 1]; // 방문 여부 초기화
        bfs(V);

        sc.close();
    }

    // DFS 구현 (재귀적)
    public static void dfs(int node) {
        visited[node] = true; // 현재 노드 방문 처리
        System.out.print(node + " "); // 방문한 노드를 출력

        // 현재 노드와 연결된 다른 노드들을 방문
        for (int next : graph[node]) {
            if (!visited[next]) { // 방문하지 않은 노드가 있으면
                dfs(next); // 재귀적으로 DFS 수행
            }
        }
    }

    // BFS 구현 (큐를 이용)
    public static void bfs(int start) {
        Queue<Integer> queue = new LinkedList<>();
        queue.offer(start); // 시작 노드를 큐에 추가
        visited[start] = true; // 시작 노드 방문 처리

        while (!queue.isEmpty()) {
            int node = queue.poll(); // 큐에서 노드를 하나 꺼내고 출력
            System.out.print(node + " ");

            // 현재 노드와 연결된 모든 노드를 확인
            for (int next : graph[node]) {
                if (!visited[next]) { // 방문하지 않은 노드를 큐에 추가
                    visited[next] = true;
                    queue.offer(next);
                }
            }
        }
    }
}

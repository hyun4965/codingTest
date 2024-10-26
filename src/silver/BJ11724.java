package silver;

import java.util.*;

public class BJ11724 {
    static ArrayList<Integer>[] graph;  // 인접 리스트로 그래프를 표현
    static boolean[] visited; // 방문 여부를 저장하는 배열
    static int N, M; // 정점과 간선의 개수

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        N = sc.nextInt();
        M = sc.nextInt();

        graph = new ArrayList[N + 1];   // 정점 번호를 1부터 사용하기 위해 N+1로 초기화
        visited = new boolean[N + 1];

        // 인접 리스트 초기화
        for (int i = 1; i <= N; i++) {
            graph[i] = new ArrayList<>();
        }

        // 간선 정보 입력
        for (int i = 0; i < M; i++) {
            int u = sc.nextInt();
            int v = sc.nextInt();

            graph[u].add(v);
            graph[v].add(u);
        }
        int count = 0;

        // 연결 요소 개수 구하기
        for (int i = 1; i <= N; i++) {
            if (!visited[i]) { // 방문하지 않은 새로운 정점이 있다면
                dfs(i);
                count++;//카운트 증가
            }
        }

        System.out.println(count);
    }

    // DFS 메서드
    static void dfs(int node) {
        visited[node] = true;

        for (int next : graph[node]) {
            if (!visited[next]) {
                dfs(next);
            }
        }
    }
}
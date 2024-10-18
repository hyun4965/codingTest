package Algorithm;
import java.util.*;

public class DFS {
    static boolean[] visited; // 방문 여부를 체크할 배열
    static ArrayList<Integer>[] graph; // 인접 리스트로 그래프를 표현

    // DFS 탐색 함수
    public static void dfs(int node) {
        visited[node] = true; // 현재 노드 방문 표시

        // 현재 노드와 연결된 다른 노드들을 방문
        for (int next : graph[node]) {
            if (!visited[next]) { // 방문하지 않은 노드에 대해 DFS 수행
                dfs(next);
            }
        }
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        // 그래프 초기화 (컴퓨터 번호는 1번부터 시작하므로 크기를 +1)
        int count = sc.nextInt();
        graph = new ArrayList[count + 1];
        for (int i = 1; i <= count; i++) {
            graph[i] = new ArrayList<>();
        }

        // 방문 배열 초기화
        visited = new boolean[count + 1];
    }
}

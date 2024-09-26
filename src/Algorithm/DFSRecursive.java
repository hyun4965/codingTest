package Algorithm;

import java.util.ArrayList;
import java.util.List;

public class DFSRecursive {

    // 그래프를 인접 리스트로 표현
    static class Graph {
        private List<List<Integer>> adjList;

        // 그래프 생성자
        public Graph(int numVertices) {
            adjList = new ArrayList<>();
            for (int i = 0; i < numVertices; i++) {
                adjList.add(new ArrayList<>());
            }
        }

        // 간선 추가 메서드
        public void addEdge(int src, int dest) {
            adjList.get(src).add(dest);
        }

        // DFS 재귀 호출 메서드
        public void dfs(int startVertex) {
            boolean[] visited = new boolean[adjList.size()];
            dfsRecursive(startVertex, visited);
        }

        // DFS 재귀 호출의 실제 로직
        private void dfsRecursive(int vertex, boolean[] visited) {
            visited[vertex] = true;
            System.out.print(vertex + " "); // 방문한 노드 출력

            // 인접한 모든 노드에 대해 재귀적으로 탐색
            for (int neighbor : adjList.get(vertex)) {
                if (!visited[neighbor]) {
                    dfsRecursive(neighbor, visited);
                }
            }
        }
    }
}
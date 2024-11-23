package Algorithm;

import java.util.ArrayList;
import java.util.List;

public class HamiltonianCycleCounter {
    static int[][] graph;
    static int numVertices;

    public static void main(String[] args) {
        numVertices = 6;
        graph = new int[numVertices][numVertices];

        // 변경된 연결 정보
        addEdge(1, 2);
        addEdge(1, 3);
        addEdge(1, 6);
        addEdge(2, 3);
        addEdge(2, 4);
        addEdge(2, 5);
        addEdge(2, 6);
        addEdge(3, 4);
        addEdge(4, 5);
        addEdge(5, 6);

        List<List<Integer>> allCycles = findAllHamiltonianCycles();
        System.out.println("총 해밀토니안 회로 개수: " + allCycles.size());
        if (!allCycles.isEmpty()) {
            System.out.println("해밀토니안 회로:");
            for (List<Integer> cycle : allCycles) {
                // 1-based 노드 번호로 변환하여 출력
                List<Integer> adjustedCycle = new ArrayList<>();
                for (int node : cycle) {
                    adjustedCycle.add(node + 1);
                }
                System.out.println(adjustedCycle);
            }
        }
    }

    static void addEdge(int u, int v) {
        graph[u - 1][v - 1] = 1;
        graph[v - 1][u - 1] = 1;
    }

    static List<List<Integer>> findAllHamiltonianCycles() {
        List<List<Integer>> allCycles = new ArrayList<>();
        List<Integer> path = new ArrayList<>();
        path.add(0);
        boolean[] visited = new boolean[numVertices];
        visited[0] = true;

        findCycles(0, path, visited, allCycles);
        return allCycles;
    }

    static void findCycles(int current, List<Integer> path, boolean[] visited, List<List<Integer>> allCycles) {
        if (path.size() == numVertices) {
            if (graph[current][path.get(0)] == 1) {
                List<Integer> cycle = new ArrayList<>(path);
                cycle.add(path.get(0));
                allCycles.add(cycle);
            }
            return;
        }

        for (int v = 0; v < numVertices; v++) {
            if (!visited[v] && graph[current][v] == 1) {
                visited[v] = true;
                path.add(v);
                findCycles(v, path, visited, allCycles);
                path.remove(path.size() - 1);
                visited[v] = false;
            }
        }
    }
}
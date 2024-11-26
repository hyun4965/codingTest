package middle2;

public class Subject5 {
    static int n; // 그래프 정점의 개수
    static int[][] G; // 그래프의 인접 행렬
    static int[] path; // 현재까지의 경로

    public static void main(String[] args) {
        n = 6; // 정점 개수 (4에서 6으로 확장)
        G = new int[n][n]; // 그래프의 인접 행렬 초기화

        // 간선 추가 (addEdge 호출)
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

        path = new int[n];
        path[0] = 0; // 시작 정점 설정 (1번 정점, 0-based 인덱스)
        hamiltonian(1); // 탐색 시작
    }

    // addEdge 메서드: 간선 추가
    static void addEdge(int u, int v) {
        // 간선 추가는 0-based 인덱스로 처리
        G[u - 1][v - 1] = 1;
        G[v - 1][u - 1] = 1; // 무방향 그래프이므로 양방향 설정
    }

    static void hamiltonian(int i) {
        if (i == n) {
            // 경로가 완성되었고, 마지막 정점이 시작 정점으로 돌아올 수 있는 경우
            if (G[path[i - 1]][path[0]] == 1) {
                printPath();
            }
            return;
        }
        // 다음 정점을 시도
        for (int j = 1; j < n; j++) {
            path[i] = j;
            if (valid(i)) {
                hamiltonian(i + 1);
            }
        }
    }

    static boolean valid(int i) {
        // 경로의 마지막 정점이 시작 정점과 연결되지 않는 경우
        if (i == n && G[path[i - 1]][path[0]] == 0) {
            return false;
        }
        // 현재 정점과 이전 정점이 연결되지 않은 경우
        if (i > 0 && G[path[i - 1]][path[i]] == 0) {
            return false;
        }
        // 이미 방문한 정점인지 확인
        for (int j = 0; j < i; j++) {
            if (path[j] == path[i]) {
                return false;
            }
        }
        return true;
    }

    static void printPath() {
        for (int i = 0; i < n; i++) {
            System.out.print((path[i] + 1) + " "); // 1-based 출력
        }
        System.out.println(path[0] + 1); // 마지막에 시작 정점으로 돌아오는 경로 추가
    }
}

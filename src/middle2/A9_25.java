package middle2;

public class A9_25 {
    static int n; // 그래프 정점의 개수
    static int[][] G; // 그래프의 인접 행렬
    static int[] path; // 현재까지의 경로

    public static void main(String[] args) {
        // 그래프 초기화 예제
        n = 4; // 정점 개수
        G = new int[][] {
                {0, 1, 1, 0},
                {1, 0, 1, 1},
                {1, 1, 0, 1},
                {0, 1, 1, 0}
        };
        path = new int[n];
        path[0] = 0; // 시작 정점 설정
        hamiltonian(1); // 탐색 시작
    }

    static void hamiltonian(int i) {
        if (i == n) {
            // 경로가 완성되었고, 마지막 정점이 시작 정점으로 돌아올 수 있는 경우
            if (G[path[i - 1]][path[0]] == 1) {
                for (int m = 0; m < n; m++) {
                    System.out.print(path[m] + " ");
                }
                System.out.println(path[0]); // 마지막에 시작 정점으로 돌아오는 경로 추가
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
        // 경로의 마지막 정점이 첫 정점과 연결되지 않는 경우
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
}

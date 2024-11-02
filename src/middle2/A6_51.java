package middle2;

public class A6_51 {

    final static int INF = 99999; // 무한대 값을 설정하여 연결되지 않은 경우를 표현

    public static void floydWarshall(int[][] W) {
        int n = W.length;
        int[][] D = new int[n][n];

        // 초기 D^(0) 설정: D^(0) = W
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                D[i][j] = W[i][j];
            }
        }

        // 플로이드-워셜 알고리즘 적용
        for (int k = 0; k < n; k++) {
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    // d^(k)_(ij) = min(d^(k-1)_(ij), d^(k-1)_(ik) + d^(k-1)_(kj))
                    D[i][j] = Math.min(D[i][j], D[i][k] + D[k][j]);
                }
            }
        }

        // 최단 경로 행렬 출력
        printSolution(D);
    }

    public static void printSolution(int[][] D) {
        int n = D.length;
        System.out.println("All-Pairs Shortest Paths:");
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (D[i][j] == INF) {
                    System.out.print("INF ");
                } else {
                    System.out.print(D[i][j] + " ");
                }
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        int[][] W = {
                {0, 3, INF, 7},
                {8, 0, 2, INF},
                {5, INF, 0, 1},
                {2, INF, INF, 0}
        };

        floydWarshall(W);
    }
}

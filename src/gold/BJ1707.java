package gold;

import java.util.*;

public class BJ1707 {

    static List<Integer>[] graph;
    static int[] color; // 0: 방문X, 1: 집합 A, -1: 집합 B
    static int V, E;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int K = sc.nextInt();

        for(int i=0; i<=V;i++){
            V=sc.nextInt();
            E=sc.nextInt();
            graph = new ArrayList[V+1];
            color = new int[V+1];

            for(int j=1;j<=V;j++){
                graph[j] = new ArrayList<>();
                color[j] = 0;
            }
            for (int j = 0; j < E; j++) {
                int u = sc.nextInt();
                int v = sc.nextInt();
                graph[u].add(v);
                graph[v].add(u);
            }
            boolean isBipartite = true;
            for (int j = 1; j <= V; j++) {
                if (color[j] == 0) { // 방문하지 않은 노드만 BFS 실행
                    if (!bfs(j)) {
                        isBipartite = false;
                        break;
                    }
                }
            }

            // 결과 즉시 출력
            if (isBipartite) {
                System.out.println("YES");
            } else {
                System.out.println("NO");
            }
        }

    }
    static boolean bfs(int start) {
        Queue<Integer> queue = new LinkedList<>();
        queue.add(start);
        color[start] = 1; // 첫 정점을 집합 1로 색칠

        for (; !queue.isEmpty(); ) {
            int cur = queue.poll();

            for (int next : graph[cur]) {
                if (color[next] == 0) { // 방문 안 했으면 반대 색으로 칠하기
                    color[next] = -color[cur];
                    queue.add(next);
                } else if (color[next] == color[cur]) { // 같은 색이면 이분 그래프 아님
                    return false;
                }
            }
        }
        return true;
    }
}

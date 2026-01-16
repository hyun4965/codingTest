package news;

import java.util.*;

public class BJ1707 {

    static List<Integer>[] graph;
    static int[] color;
    static int V, E;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int K = sc.nextInt();

        for(int i=0; i < K; i++){
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
                if (color[j] == 0) {
                    if (!bfs(j)) {
                        isBipartite = false;
                        break;
                    }
                }
            }

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
        color[start] = 1;

        while (!queue.isEmpty()) {
            int cur = queue.poll();

            for (int next : graph[cur]) {
                if (color[next] == 0) {
                    color[next] = -color[cur];
                    queue.add(next);
                } else if (color[next] == color[cur]) {
                    return false;
                }
            }
        }
        return true;
    }
}

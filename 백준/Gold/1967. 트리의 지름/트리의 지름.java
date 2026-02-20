import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main {
    static int n;

    static class Edge {
        int to;
        int weight;

        Edge(int to, int weight) {
            this.to = to;
            this.weight = weight;
        }
    }

    static ArrayList<Edge>[] tree;
    static boolean[] visited;

    static int maxDist = 0;
    static int farNode = 1;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        n = Integer.parseInt(br.readLine());
        tree = new ArrayList[n + 1];

        // graph 생성
        for (int i = 1; i <= n; i++) {
            tree[i] = new ArrayList<>();
        }

        // graph 입력
        for (int i = 0; i < n - 1; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            int weight = Integer.parseInt(st.nextToken());

            tree[u].add(new Edge(v, weight));
            tree[v].add(new Edge(u, weight));
        }

        visited = new boolean[n + 1];
        maxDist = 0;
        farNode = 1;
        dfs(1, 0);

        visited = new boolean[n + 1];
        maxDist = 0;
        dfs(farNode, 0);

        System.out.println(maxDist);
    }

    static void dfs(int node, int dist) {
        visited[node] = true;

        if (dist > maxDist) {
            maxDist = dist;
            farNode = node;
        }

        for (Edge e : tree[node]) {
            if (!visited[e.to]) {
                dfs(e.to, dist + e.weight);
            }
        }
    }
}

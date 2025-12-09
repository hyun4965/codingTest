import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.StringTokenizer;

public class Main {
    static int[] parent;
    static int[] rank;

    static int find(int x) {
        if (parent[x] == x) return x;
        parent[x] = find(parent[x]);
        return parent[x];
    }

    static void union(int a, int b) {
        int pa = find(a);
        int pb = find(b);
        if (pa == pb) return;

        if (rank[pa] < rank[pb]) {
            parent[pa] = pb;
        } else if (rank[pa] > rank[pb]) {
            parent[pb] = pa;
        } else {
            parent[pb] = pa;
            rank[pa]++;
        }
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        parent = new int[n + 1];
        rank = new int[n + 1];

        for (int i = 0; i <= n; i++) {
            parent[i] = i;
            rank[i] = 0;
        }

        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int cmd = Integer.parseInt(st.nextToken());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            if (cmd == 0) {
                union(a, b);
            } else {
                if (find(a) == find(b)) sb.append("YES\n");
                else sb.append("NO\n");
            }
        }

        System.out.print(sb.toString());
    }
}

package gold;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class BJ1967 {
    static class Node {
        int to, weight;

        Node(int to, int weight) {
            this.to = to;
            this.weight = weight;
        }
    }

    static int n;
    static List<Node>[] tree; //트리
    static boolean[] visited;
    static int maxDistance = 0, farthestNode = 0; //최대 거리와

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        n = Integer.parseInt(br.readLine());//노드의 개수 입력

        if (n == 0) {
            System.out.println(0);
            return;
        }
        if (n == 1) {
            System.out.println(0);
            return;
        }

        tree = new ArrayList[n + 1];
        for (int i = 1; i <= n; i++) {
            tree[i] = new ArrayList<>();
        }

        for (int i = 0; i < n - 1; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int parent = Integer.parseInt(st.nextToken()); //부모 노드
            int child = Integer.parseInt(st.nextToken()); //자식 노드
            int weight = Integer.parseInt(st.nextToken()); //가중치

            // 무방향 그래프
            tree[parent].add(new Node(child, weight));
            tree[child].add(new Node(parent, weight));
        }

        // 첫 번째 DFS (루트 노드 1번에서 가장 먼 노드 찾기)
        visited = new boolean[n + 1];
        dfs(1, 0);

        // 두 번째 DFS (가장 먼 노드에서 가장 먼 거리 구하기)
        visited = new boolean[n + 1];
        maxDistance = 0;
        dfs(farthestNode, 0);

        System.out.println(maxDistance);

    }
    private static void dfs(int node, int distance) {
        if (node <= 0 || node > n || visited[node]) {
            return;
        }
        if (tree[node] == null) {
            return;
        }

        visited[node] = true;

        if (distance > maxDistance) {
            maxDistance = distance;
            farthestNode = node;
        }

        for (Node neighbor : tree[node]) {
            if (!visited[neighbor.to]) {
                dfs(neighbor.to, distance + neighbor.weight);
            }
        }
    }
}

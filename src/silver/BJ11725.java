package silver;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class BJ11725 {
    static boolean[] visited; // 방문 여부를 체크할 배열
    static ArrayList<Integer>[] graph; // 인접 리스트로 그래프를 표현
    static int[] parent; //노드의 부모 저장
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();

        graph = new ArrayList[N+1];
        visited = new boolean[N+1];
        parent = new int[N+1];

        for (int i = 1; i <= N; i++) {
            graph[i] = new ArrayList<>();
        }
        //간선입력
        for (int i = 0; i < N - 1; i++) {
            int a = sc.nextInt();
            int b = sc.nextInt();
            graph[a].add(b);
            graph[b].add(a);
        }
        bfs(1);
        for (int i = 2; i <= N; i++) {
            System.out.println(parent[i]);
        }
    }
    public static void bfs(int start) {
        Queue<Integer> queue = new LinkedList<>();
        queue.offer(start);
        visited[start] = true;
        while (!queue.isEmpty()) {
            int node = queue.poll();
            for (int next : graph[node]) {
                if (!visited[next]) {
                    visited[next] = true;
                    parent[next] = node;
                    queue.offer(next);
                }

            }
        }
    }
}

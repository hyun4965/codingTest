package news;

import java.util.*;

public class BJ1167 {
    static int V;
    static List<Node>[] list;
    static boolean[] visited;
    static int[] distance;
    static int maxDistance;
    static int farNode;

    public static class Node{
        private int now;
        private int next;

        public Node(int now, int next) {
            this.now = now;
            this.next = next;
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();
        V =N;
        list = new ArrayList[N + 1];
        for(int i = 1; i <= V; i++) {
            list[i] = new ArrayList<>();
        }
        for(int i = 0; i < V; i++) {
            int now = sc.nextInt();
            while(true){
                int e = sc.nextInt();
                if(e ==-1){
                    break;
                }
                int v = sc.nextInt();
                list[now].add(new Node(e,v));
            }

        }

        bfs(1);
        bfs(farNode);

        System.out.println(maxDistance);
    }
    static void bfs(int n){
        visited = new boolean[V + 1];
        distance = new int[V + 1];
        maxDistance = 0;

        Queue<Integer> queue = new LinkedList<>();
        queue.offer(n);
        visited[n] = true;

        while(!queue.isEmpty()){
            int cur = queue.poll();

            for(Node node : list[cur]){
                if(!visited[node.now]){
                    visited[node.now] = true;
                    distance[node.now] = distance[cur] + node.next;
                    queue.offer(node.now);

                    if(distance[node.now] > maxDistance){
                        maxDistance = distance[node.now];
                        farNode = node.now;
                    }
                }
            }
        }
    }
}

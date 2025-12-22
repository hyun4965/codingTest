import java.util.*;

public class Main {
    static class node implements Comparable<node> {

        private int position, value;

        public node(int position, int value) {
            this.position = position;
            this.value = value;
        }
        @Override
        public int compareTo(node o) {
            return Integer.compare(this.value, o.value);
        }
    }

    static final int INF = 1_000_000_000;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt(); // 마을 수
        int M = sc.nextInt(); // 도로 수
        int X = sc.nextInt(); // 파티 장소

        List<List<node>> graph = new ArrayList<>();
        List<List<node>> rGraph = new ArrayList<>();
        for (int i = 0; i <= N; i++) {
            graph.add(new ArrayList<>());
            rGraph.add(new ArrayList<>());
        }

        // 도로 입력
        for (int i = 0; i < M; i++) {
            int A = sc.nextInt();
            int B = sc.nextInt();
            int T = sc.nextInt();
            graph.get(A).add(new node(B, T));
            rGraph.get(B).add(new node(A, T));
        }

        // X -> i
        int[] fromX = dijkstra(X, N, graph);

        // i -> X
        int[] toX = dijkstra(X, N, rGraph);

        // 최대 왕복 시간
        int answer = 0;
        for (int i = 1; i <= N; i++) {
            answer = Math.max(answer, fromX[i] + toX[i]);
        }

        System.out.println(answer);
        sc.close();
    }

    // 다익스트라
    static int[] dijkstra(int start, int N, List<List<node>> graph) {
        int[] dist = new int[N + 1];
        Arrays.fill(dist, INF);
        dist[start] = 0;

        PriorityQueue<node> queue = new PriorityQueue<>();
        queue.add(new node(start, 0));

        while (!queue.isEmpty()) {
            node cur = queue.poll();

            if (cur.value > dist[cur.position]) {
                continue;
            }

            for (node next : graph.get(cur.position)) {
                int nd = cur.value + next.value;
                if (dist[next.position] > nd) {
                    dist[next.position] = nd;
                    queue.add(new node(next.position, nd));
                }
            }
        }
        return dist;
    }
}

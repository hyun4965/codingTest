package silver;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class BJ5014 {
    static int F, S, G, U, D;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        F = Integer.parseInt(st.nextToken());
        S = Integer.parseInt(st.nextToken());
        G = Integer.parseInt(st.nextToken());
        U = Integer.parseInt(st.nextToken());
        D = Integer.parseInt(st.nextToken());

        bfs();
    }
    static void bfs() {
        boolean[] visited = new boolean[F + 1];
        int[] dist = new int[F + 1];

        Queue<Integer> q = new ArrayDeque<>();
        q.add(S);
        visited[S] = true;

        while (!q.isEmpty()) {
            int cur = q.poll();

            if (cur == G) {
                System.out.print(dist[cur]);
                return;
            }

            int up = cur + U;
            if (up <= F && !visited[up]) {
                visited[up] = true;
                dist[up] = dist[cur] + 1;
                q.add(up);
            }

            int down = cur - D;
            if (down >= 1 && !visited[down]) {
                visited[down] = true;
                dist[down] = dist[cur] + 1;
                q.add(down);
            }
        }

        System.out.print("use the stairs");
    }
}
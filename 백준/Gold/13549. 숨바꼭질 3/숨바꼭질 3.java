import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.StringTokenizer;

public class Main {
    static final int MAX = 100000;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        int[] dist = new int[MAX + 1];
        for (int i = 0; i <= MAX; i++) dist[i] = -1;

        Deque<Integer> dq = new ArrayDeque<>();
        dq.add(N);
        dist[N] = 0;

        while (!dq.isEmpty()) {
            int x = dq.pollFirst();
            if (x == K) break;

            int nx = x * 2;
            if (nx <= MAX && dist[nx] == -1) {
                dist[nx] = dist[x];
                dq.addFirst(nx);
            }

            nx = x - 1;
            if (nx >= 0 && dist[nx] == -1) {
                dist[nx] = dist[x] + 1;
                dq.addLast(nx);
            }

            nx = x + 1;
            if (nx <= MAX && dist[nx] == -1) {
                dist[nx] = dist[x] + 1;
                dq.addLast(nx);
            }
        }

        System.out.println(dist[K]);
    }
}

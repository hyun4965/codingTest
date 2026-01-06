package gold;

import java.util.*;

public class BJ12851 {
    static final int MAX = 100000;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int K = sc.nextInt();

        if (N == K) {
            System.out.println(0);
            System.out.println(1);
            return;
        }

        int[] dist = new int[MAX + 1];
        int[] cnt = new int[MAX + 1];
        Arrays.fill(dist, -1);

        Queue<Integer> q = new ArrayDeque<>();
        q.add(N);
        dist[N] = 0;
        cnt[N] = 1;

        while (!q.isEmpty()) {
            int x = q.poll();

            if (dist[K] != -1 && dist[x] >= dist[K]) {
                continue;
            }

            int[] nexts = new int[]{x - 1, x + 1, x * 2};

            for (int nx : nexts) {
                if (nx < 0 || nx > MAX) continue;

                if (dist[nx] == -1) {
                    dist[nx] = dist[x] + 1;
                    cnt[nx] = cnt[x];
                    q.add(nx);
                } else if (dist[nx] == dist[x] + 1) {
                    cnt[nx] += cnt[x];
                }
            }
        }

        System.out.println(dist[K]);
        System.out.println(cnt[K]);
    }
}

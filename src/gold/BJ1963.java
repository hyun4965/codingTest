package gold;
import java.util.*;

public class BJ1963 {

    static boolean[] isPrime = new boolean[10000];

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        Arrays.fill(isPrime, true);
        isPrime[0] = isPrime[1] = false;

        for (int i = 2; i * i < 10000; i++) {
            if (!isPrime[i]) continue;
            for (int j = i * i; j < 10000; j += i) {
                isPrime[j] = false;
            }
        }

        int T = sc.nextInt();

        while (T-- > 0) {
            int start = sc.nextInt();
            int target = sc.nextInt();

            int result = bfs(start, target);

            if (result == -1) {
                System.out.println("Impossible");
            } else {
                System.out.println(result);
            }
        }
    }

    private static int bfs(int start, int target) {
        if (start == target) {
            return 0;
        }

        int[] dist = new int[10000];
        Arrays.fill(dist, -1);

        Queue<Integer> q = new LinkedList<>();
        q.offer(start);
        dist[start] = 0;

        while (!q.isEmpty()) {
            int cur = q.poll();
            char[] arr = String.valueOf(cur).toCharArray();

            for (int pos = 0; pos < 4; pos++) {
                char original = arr[pos];

                for (char d = '0'; d <= '9'; d++) {
                    if (d == original) continue;
                    if (pos == 0 && d == '0') continue;

                    arr[pos] = d;
                    int next = Integer.parseInt(new String(arr));

                    if (!isPrime[next]) {
                        arr[pos] = original;
                        continue;
                    }

                    if (dist[next] == -1) {
                        dist[next] = dist[cur] + 1;
                        if (next == target) return dist[next];
                        q.offer(next);
                    }

                    arr[pos] = original;
                }
            }
        }

        return -1;
    }
}
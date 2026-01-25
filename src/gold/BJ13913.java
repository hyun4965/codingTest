package gold;

import java.util.*;

public class BJ13913 {
    static int n, k;
    static int[] parent = new int[100001];
    static int[] time = new int[100001];

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        k = sc.nextInt();

        bfs();

        StringBuilder sb = new StringBuilder();

        sb.append(time[k] - 1).append("\n");

        Stack<Integer> stack = new Stack<>();
        int index = k;

        while (index != n) {
            stack.push(index);
            index = parent[index];
        }
        stack.push(n);

        while (!stack.isEmpty()) {
            sb.append(stack.pop()).append(" ");
        }

        System.out.println(sb);
    }

    static void bfs() {
        Queue<Integer> q = new LinkedList<>();
        q.add(n);
        time[n] = 1;

        while (!q.isEmpty()) {
            int now = q.poll();

            //동생을 찾음.
            if (now == k) {
                return;
            }

            //이동 가능한 경우 3가지
            int[] nextMoves = {now - 1, now + 1, now * 2};

            for (int next : nextMoves) {
                if (next >= 0 && next <= 100000 && time[next] == 0) {
                    time[next] = time[now] + 1;
                    parent[next] = now;
                    q.add(next);
                }
            }
        }
    }
}
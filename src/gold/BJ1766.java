package gold;

import java.util.*;

public class BJ1766 {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt(); // 문제 수
        int M = sc.nextInt(); // 정보 수

        List<List<Integer>> graph = new ArrayList<>();
        for (int i = 0; i <= N; i++) {
            graph.add(new ArrayList<>());
        }
        int[] book = new int[N + 1];

        for (int i = 0; i < M; i++) {
            int A = sc.nextInt();
            int B = sc.nextInt();
            graph.get(A).add(B);
            book[B]++;
        }

        PriorityQueue<Integer> pq = new PriorityQueue<>();

        for (int i = 1; i <= N; i++) {
            if (book[i] == 0) {
                pq.offer(i);
            }
        }

        StringBuilder sb = new StringBuilder();

        while (!pq.isEmpty()) {
            int cur = pq.poll();
            sb.append(cur).append(" ");

            for (int next : graph.get(cur)) {
                if (--book[next] == 0) {
                    pq.offer(next);
                }
            }
        }

        System.out.println(sb.toString().trim());
    }
}
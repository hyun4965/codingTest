package gold;

import java.util.*;

public class BJ2696 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();

        while (T-- > 0) {
            int M = sc.nextInt();
            int count = (M + 1) / 2;
            System.out.println(count);

            PriorityQueue<Integer> left = new PriorityQueue<>(Collections.reverseOrder()); // 최대 힙
            PriorityQueue<Integer> right = new PriorityQueue<>();

            int printed = 0;
            for (int i = 1; i <= M; i++) {
                int x = sc.nextInt();

                if (left.isEmpty() || x <= left.peek()) left.add(x);
                else right.add(x);

                if (left.size() < right.size()) {
                    left.add(right.poll());
                } else if (left.size() - right.size() > 1) {
                    right.add(left.poll());
                }

                if (i % 2 == 1) {
                    System.out.print(left.peek() + " ");
                    printed++;
                    if (printed % 10 == 0) {
                        System.out.println();
                    }
                }
            }
            if (printed % 10 != 0) {
                System.out.println();
            }
        }
    }
}

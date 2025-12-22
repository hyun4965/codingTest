package news;

import java.util.Collections;
import java.util.PriorityQueue;
import java.util.Scanner;

public class BJ11279 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        PriorityQueue<Integer> queue = new PriorityQueue<>(Collections.reverseOrder()); // 최대힙
        StringBuilder sb = new StringBuilder();
        while (n-- > 0) {
            int num = sc.nextInt();

            if (num == 0) {
                if (queue.isEmpty()) {
                    sb.append(0).append('\n');
                } else {
                    sb.append(queue.poll()).append('\n');
                }
            } else {
                queue.add(num);
            }
        }
        System.out.println(sb.toString());
    }
}

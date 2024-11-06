package gold;

import java.util.PriorityQueue;
import java.util.Scanner;

public class BJ1715 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int result =0;
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for (int i = 0; i < N; i++) {
            pq.add(sc.nextInt());
        }

        while (pq.size() > 1) {
            int first = pq.poll();
            int second = pq.poll();
            result += (first + second);
            pq.add(first + second);
        }
        System.out.println(result);
    }
}

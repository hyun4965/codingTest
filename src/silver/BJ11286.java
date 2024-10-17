package silver;

import java.util.Collections;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Scanner;

public class BJ11286 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        //비교연산자 구현
        Comparator<Integer> comparator = new Comparator<Integer>() {
            @Override
            public int compare(Integer a, Integer b) {
                if (Math.abs(a) == Math.abs(b)) {
                    return Integer.compare(a, b);
                } else {
                    return Integer.compare(Math.abs(a), Math.abs(b));
                }
            }
        };

        PriorityQueue<Integer> priorityQueue = new PriorityQueue<>(comparator);
        for (int i = 0; i < N; i++) {
            int x = sc.nextInt();
            if (x != 0) {
                priorityQueue.add(x);
            } else {
                if (priorityQueue.isEmpty()) {
                    System.out.println(0);
                } else {
                    System.out.println(priorityQueue.poll());
                }
            }
        }
    }
}

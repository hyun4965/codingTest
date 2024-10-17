package silver;

import java.util.Collections;
import java.util.PriorityQueue;
import java.util.Scanner;

public class BJ11279 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        PriorityQueue<Integer> priorityQueue = new PriorityQueue<>(Collections.reverseOrder());
        for (int i = 0; i < N; i++) {
            int x = sc.nextInt();
            priorityQueue.add(x);
            if(x==0){
                System.out.println(priorityQueue.poll());
            }
        }
    }
}

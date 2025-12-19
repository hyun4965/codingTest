package news;

import java.util.PriorityQueue;
import java.util.Scanner;

public class BJ1715 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt(); // 묶음수
        PriorityQueue<Integer> queue = new PriorityQueue<>();

        for (int i = 0; i < n; i++) {
            queue.add(sc.nextInt());
        }

        int answer = 0;

        while(queue.size() > 1) {
            int num = queue.poll()+queue.poll();
            answer +=num;
            queue.add(num);
        }

        System.out.println(answer);

    }
}

package silver;

import java.util.PriorityQueue;
import java.util.Scanner;

public class BJ1927 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        PriorityQueue<Integer> priorityQueue = new PriorityQueue<>(); //우선 순위 큐 . 작은수.. 만약 큰수면 () 안에 Collection reverse 해야함
        int N = sc.nextInt();

        for (int i = 0; i < N; i++) {
            int x = sc.nextInt();
            if (x != 0) {
                priorityQueue.add(x); // 자연수 x를 힙에 추가
            } else {
                // x가 0일 때 가장 작은 값 출력 및 제거
                if (priorityQueue.isEmpty()) {
                    System.out.println(0); // 힙이 비어있으면 0 출력
                } else {
                    System.out.println(priorityQueue.poll()); // 가장 작은 값 출력
                }
            }
        }
    }
}

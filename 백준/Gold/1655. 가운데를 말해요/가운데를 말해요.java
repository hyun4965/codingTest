import java.util.Collections;
import java.util.PriorityQueue;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt(); //정수의 갯수
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Collections.reverseOrder());
        PriorityQueue<Integer> minHeap = new PriorityQueue<>();
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < n; i++) {
            int num = sc.nextInt();

            if (maxHeap.size() == minHeap.size()) {
                maxHeap.add(num);
            } else {
                minHeap.add(num);
            }

            if (!minHeap.isEmpty() && maxHeap.peek() > minHeap.peek()) {
                int tempMax = maxHeap.poll();
                int tempMin = minHeap.poll();
                maxHeap.add(tempMin);
                minHeap.add(tempMax);
            }

            sb.append(maxHeap.peek()).append("\n");
        }

        System.out.print(sb);
    }
}

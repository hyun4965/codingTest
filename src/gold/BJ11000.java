package gold;

import java.io.IOException;
import java.util.PriorityQueue;
import java.util.Scanner;

public class BJ11000 {
    static int N;

    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);

        N = sc.nextInt();

        PriorityQueue<int[]> queue = new PriorityQueue<>((o1, o2) ->{
            if(o1[0] == o2[0]){
                return o1[1] - o2[1];
            }
            return o1[0] - o2[0];
        });

        for(int i=0; i<N; i++){
            int start = sc.nextInt();
            int end = sc.nextInt();
            queue.add(new int[]{start, end});
        }

        PriorityQueue<Integer> room = new PriorityQueue<>();
        while (!queue.isEmpty()) {
            int[] cur = queue.poll();

            if (!room.isEmpty() && room.peek() <= cur[0]) {
                room.poll();
            }
            room.offer(cur[1]);
        }

        System.out.println(room.size());
    }
}

package silver;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class BJ1697 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int K = sc.nextInt();

        boolean[] visited = new boolean[100001];

        Queue<int[] > queue = new LinkedList<>();
        queue.add(new int[]{N, 0});
        visited[N] = true;

        while (!queue.isEmpty()) {
            int[] current = queue.poll();
            int position = current[0];
            int time = current[1];
            if(position == K) {
                System.out.println(time);
                return;
            }
            int[] nextPositions = {position -1, position + 1,position * 2};
            for(int next: nextPositions) {
                if(next>=0 && next<=100000 && !visited[next]) {
                    queue.add(new int[]{next, time+1});
                    visited[next] = true;
                }
            }
        }
        sc.close();
    }
}

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        int n = sc.nextInt();
        int k = sc.nextInt();

        boolean[] visited = new boolean[100001];
        Queue<int[]> queue = new LinkedList<>();

        queue.add(new int[] {n, 0});
        visited[n] = true;

        while (!queue.isEmpty()) {
            int[] cur = queue.poll();
            int position = cur[0];
            int time = cur[1];

            if (position == k) {
                System.out.println(time);
                return;
            }

            int[] nextPositions = {position - 1, position + 1, position * 2};
            for (int next : nextPositions) {
                if (next >= 0 && next <= 100000 && !visited[next]) {
                    visited[next] = true;
                    queue.add(new int[] {next, time + 1});
                }
            }
        }
        sc.close();
    }
}

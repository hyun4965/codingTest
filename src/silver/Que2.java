package silver;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;

public class Que2 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Deque<Integer> q = new ArrayDeque<>();
        StringBuilder sb = new StringBuilder();
        int N = Integer.parseInt(br.readLine());

        for (int i = 0; i < N; i++) {
            String[] command = br.readLine().split(" ");

            switch(command[0]) {
                case "push":
                    int x = Integer.parseInt(command[1]);
                    q.add(x);
                    break;

                case "pop":
                    if (q.isEmpty()) {
                        sb.append("-1").append("\n");
                    } else {
                        sb.append(q.pollFirst()).append("\n");
                    }
                    break;

                case "size":
                    sb.append(q.size()).append("\n");
                    break;

                case "empty":
                    sb.append(q.isEmpty() ? 1 : 0).append("\n");
                    break;

                case "front":
                    if (q.isEmpty()) {
                        sb.append("-1").append("\n");
                    } else {
                        sb.append(q.peekFirst()).append("\n");
                    }
                    break;

                case "back":
                    if (q.isEmpty()) {
                        sb.append("-1").append("\n");
                    } else {
                        sb.append(q.peekLast()).append("\n");
                    }
                    break;
            }
        }
        System.out.print(sb);
    }
}
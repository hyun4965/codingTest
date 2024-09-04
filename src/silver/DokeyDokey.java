package silver;


import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;
import java.util.StringTokenizer;

public class DokeyDokey {
    public static void main(String[] args) throws Exception {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(in.readLine());

        Queue<Integer> q = new LinkedList<>();
        Stack<Integer> s = new Stack<>();

        StringTokenizer st = new StringTokenizer(in.readLine(), " ");
        for (int i = 0; i < N; i++) {
            q.offer(Integer.parseInt(st.nextToken()));
        }

        int start = 1;

        while (!q.isEmpty()) {
            if (q.peek() == start) {
                q.poll();
                start++;
            } else if (!s.isEmpty() && s.peek() == start) {
                s.pop();
                start++;
            } else {
                s.push(q.poll());
            }
        }
        while (!s.isEmpty()) {
            if (s.peek() == start) {
                s.pop();
                start++;
            } else {    // 간식 순서 틀림
                System.out.println("Sad");
                return;
            }
        }
        System.out.println("Nice");
    }
}
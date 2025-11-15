package silver;

import java.util.*;

public class BJ2161 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        Queue<Integer> q = new LinkedList<>();
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            q.add(i+1);
        }
        while (q.size() > 1) {
            list.add(q.poll());
            q.add(q.poll());
        }
        for (int x : list) {
            System.out.print(x + " ");
        }
        System.out.print(q.peek());
    }
}

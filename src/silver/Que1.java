package silver;

import java.util.*;

public class Que1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Deque<Integer> queue = new ArrayDeque<>();

        int n = sc.nextInt();
        for (int i = 0; i < n; i++) {
            String command = sc.next();

            switch (command) {
                case "push":
                    int x = sc.nextInt();
                    queue.add(x);  // 또는 queue.addLast(x);
                    break;

                case "pop":
                    if (queue.isEmpty()) {
                        System.out.println(-1);
                    } else {
                        System.out.println(queue.poll());
                    }
                    break;

                case "size":
                    System.out.println(queue.size());
                    break;

                case "empty":
                    if (queue.isEmpty()) {
                        System.out.println(1);
                    } else {
                        System.out.println(0);
                    }
                    break;

                case "front":
                    if (queue.isEmpty()) {
                        System.out.println(-1);
                    } else {
                        System.out.println(queue.peek());
                    }
                    break;

                case "back":
                    if (queue.isEmpty()) {
                        System.out.println(-1);
                    } else {
                        System.out.println(queue.peekLast());
                    }
                    break;
            }
        }
        sc.close();
    }
}
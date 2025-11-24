import java.util.Deque;
import java.util.LinkedList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        sc.nextLine();
        StringBuilder sb = new StringBuilder();
        Deque<Integer> queue = new LinkedList<>();
        while(n-- > 0) {
            String[] str = sc.nextLine().split(" ");

            if (str[0].equals("push")) {
                int num = Integer.parseInt(str[1]);
                queue.add(num);
            } else if (str[0].equals("pop")) {
                if (queue.isEmpty()) {
                    sb.append("-1").append("\n");
                } else {
                    sb.append(queue.pollFirst()).append("\n");
                }
            } else if (str[0].equals("front")) {
                if (queue.isEmpty()) {
                    sb.append("-1").append("\n");
                } else {
                    sb.append(queue.peekFirst()).append("\n");
                }
            } else if (str[0].equals("back")) {
                if (queue.isEmpty()) {
                    sb.append("-1").append("\n");
                } else {
                    sb.append(queue.peekLast()).append("\n");
                }
            } else if (str[0].equals("empty")) {
                if (queue.isEmpty()) {
                    sb.append("1").append("\n");
                } else {
                    sb.append("0").append("\n");
                }
            } else if (str[0].equals("size")) {
                sb.append(queue.size()).append("\n");
            }
        }
        System.out.println(sb.toString());
    }
}

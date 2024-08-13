package silver;

import java.util.Scanner;
import java.util.Stack;

public class StackSeq {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        StringBuilder sb = new StringBuilder();
        Stack<Integer> stack = new Stack<>();

        int n = scanner.nextInt();
        int[] sequence = new int[n];

        for (int i = 0; i < n; i++) {
            sequence[i] = scanner.nextInt();
        }

        int current = 1;
        boolean possible = true;

        for (int i = 0; i < n; i++) {
            int num = sequence[i];

            while (current <= num) {
                stack.push(current++);
                sb.append("+\n");
            }

            if (stack.peek() == num) {
                stack.pop();
                sb.append("-\n");
            } else {
                possible = false;
                break;
            }
        }

        if (possible) {
            System.out.print(sb);
        } else {
            System.out.println("NO");
        }

        scanner.close();
    }
}
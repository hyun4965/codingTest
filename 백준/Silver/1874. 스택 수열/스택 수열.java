import java.util.Scanner;
import java.util.Stack;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        StringBuilder sb = new StringBuilder();
        Stack<Integer> stack = new Stack<>();

        int n = sc.nextInt();
        int start = 1;

        for (int i = 0; i < n; i++) {
            int target = sc.nextInt();
            
            if (target >= start) {
                while (target >= start) {
                    stack.push(start);
                    start++;
                    sb.append("+\n");
                }
            }

            if (stack.peek() == target) {
                stack.pop();
                sb.append("-\n");
            } else {
                System.out.println("NO");
                return; 
            }
        }

        System.out.println(sb.toString());
    }
}
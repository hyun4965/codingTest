package silver;
import java.util.Scanner;
import java.util.Stack;

public class Editor {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        Stack<String> leftStack  = new Stack<>();
        Stack<String> rightStack = new Stack<>();

        String input = sc.nextLine();
        for (char c : input.toCharArray()) {
            leftStack .push(String.valueOf(c));
        }

        int N = sc.nextInt();
        sc.nextLine();

        for (int i = 0; i < N; i++) {
            String command = sc.nextLine();

            if (command.isEmpty()) {
                continue;
            }

            char c = command.charAt(0);

            switch (c) {
                case 'L':
                    if (!leftStack.isEmpty()) {
                        rightStack.push(leftStack.pop());
                    }
                    break;
                case 'D':
                    if (!rightStack.isEmpty()) {
                        leftStack.push(rightStack.pop());
                    }
                    break;
                case 'B':
                    if (!leftStack.isEmpty()) {
                        leftStack.pop();
                    }
                    break;
                case 'P':
                    if (command.length() >= 3) {
                        char t = command.charAt(2);
                        leftStack.push(String.valueOf(t));
                    }
                    break;
                default:
                    break;
            }
        }

        while (!leftStack.isEmpty()) {
            rightStack.push(leftStack.pop());
        }

        while (!rightStack.isEmpty()) {
            System.out.print(rightStack.pop());
        }
        sc.close();
    }
}

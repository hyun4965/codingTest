import java.util.Scanner;
import java.util.Stack;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();

        for(int i = 0; i < t; i++) {
            Stack<Character> stack = new Stack<>();
            String str = sc.next();
            boolean isValid = true; 

            for(int j = 0; j < str.length(); j++) {
                char c = str.charAt(j);

                if(c == '(') {
                    stack.push(c);
                } else if(c == ')') {
                    if(stack.isEmpty()) {
                        isValid = false;
                        break;
                    }
                    stack.pop();
                }
            }
            
            if(isValid && stack.isEmpty()) {
                System.out.println("YES");
            } else {
                System.out.println("NO");
            }
        }
    }
}
package gold;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Stack;

//Infix To Postfix
public class PostOrder1 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        Stack<Character> stack = new Stack<>();

        String s = br.readLine();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);

            //(A-Z)는 그대로 출력
            if (Character.isLetter(c)) {
                sb.append(c);
            }
            //괄호는 스택에
            else if (c == '(') {
                stack.push(c);
            }
            //괄호 스택에서 꺼내 출력
            else if (c == ')') {
                while (!stack.isEmpty() && stack.peek() != '(') {
                    sb.append(stack.pop());
                }
                stack.pop();
            }
            //연산자 처리
            else {
                while (!stack.isEmpty() && precedence(stack.peek()) >= precedence(c)) {
                    sb.append(stack.pop());
                }
                stack.push(c);
            }
        }

        //남아 있는 연산자 모두 출력
        while (!stack.isEmpty()) {
            sb.append(stack.pop());
        }
        System.out.println(sb.toString());
    }

    // 연산자의 우선순위 반환
    private static int precedence(char operator) {
        if (operator == '+' || operator == '-') {
            return 1;
        } else if (operator == '*' || operator == '/') {
            return 2;
        }
        return 0;  // 괄호 등은 우선순위 0으로 처리
    }
}

package gold;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Stack;

public class PostOrder1 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        Stack<Character> stack = new Stack<>();  // 후위 표기식 계산을 위한 스택

        String expression = br.readLine();  // 중위 표기식 입력
        for (int i = 0; i < expression.length(); i++) {
            char c = expression.charAt(i);

            // 1. 피연산자 (A-Z)는 그대로 출력
            if (Character.isLetter(c)) {
                sb.append(c);
            }
            // 2. 여는 괄호는 스택에 넣기
            else if (c == '(') {
                stack.push(c);
            }
            // 3. 닫는 괄호는 여는 괄호가 나올 때까지 스택에서 꺼내 출력
            else if (c == ')') {
                while (!stack.isEmpty() && stack.peek() != '(') {
                    sb.append(stack.pop());
                }
                stack.pop();  // 여는 괄호 제거
            }
            // 4. 연산자 처리
            else {
                while (!stack.isEmpty() && precedence(stack.peek()) >= precedence(c)) {
                    sb.append(stack.pop());
                }
                stack.push(c);
            }
        }

        // 5. 스택에 남아 있는 연산자 모두 출력
        while (!stack.isEmpty()) {
            sb.append(stack.pop());
        }

        // 후위 표기식 출력
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

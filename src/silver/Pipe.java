package silver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Pipe {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String input = br.readLine();

        Stack<Character> stack = new Stack<>();
        int result = 0;

        for (int i = 0; i < input.length(); i++) {
            char c = input.charAt(i);

            if (c == '(') {
                stack.push(c);
            } else {
                stack.pop(); // 닫는 괄호가 나오면 무조건 스택에서 하나를 pop

                if (input.charAt(i - 1) == '(') {
                    // 레이저인 경우 (바로 직전에 '('가 있었음)
                    result += stack.size(); // 현재 남아있는 쇠막대기의 개수만큼 잘림
                } else {
                    // 쇠막대기의 끝인 경우
                    result += 1; // 막대기가 끝나면 하나의 조각이 추가됨
                }
            }
        }

        System.out.println(result);
    }
}

package silver;


import java.util.Scanner;
import java.util.Stack;

public class PostOrder2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();
        String s = sc.next();
        double[] values = new double[26];

        for (int i = 0; i < N; i++) {
            values[i] = sc.nextDouble();
        }

        Stack<Double> stack = new Stack<>();  // 후위 표기식 계산을 위한 스택

        // 후위 표기식을 한 글자씩 처리
        for (char c : s.toCharArray()) {
            if (c >= 'A' && c <= 'Z') {
                // 피연산자일 경우: 해당하는 값을 스택에 push
                stack.push(values[c - 'A']);
            } else {
                // 연산자일 경우: 스택에서 두 값을 pop하여 연산 수행
                double b = stack.pop();
                double a = stack.pop();

                switch (c) {
                    case '+': stack.push(a + b); break;
                    case '-': stack.push(a - b); break;
                    case '*': stack.push(a * b); break;
                    case '/': stack.push(a / b); break;
                }
            }
        }

        System.out.printf("%.2f", stack.pop());
    }
}

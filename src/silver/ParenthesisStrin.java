package silver;

import java.util.Scanner;

public class ParenthesisStrin {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();

        for (int i = 0; i < N; i++) {
            String s = sc.nextLine();
            int balance = 0;
            boolean isValid = true;

            // 괄호 문자열을 한 문자씩 처리
            for (char c : s.toCharArray()) {
                if (c == '(') {
                    balance++; // 여는 괄호일 때 balance 증가
                } else if (c == ')') {
                    balance--; // 닫는 괄호일 때 balance 감소
                    if (balance < 0) {
                        isValid = false; // balance가 음수면 유효하지 않음
                        break;
                    }
                }
            }
            if (balance != 0) {
                isValid = false;
            }

            System.out.println(isValid ? "YES" : "NO");
        }
        sc.close();
    }
}
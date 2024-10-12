package bronze;

import java.util.Scanner;

public class BJ2744 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String input = sc.next();
        StringBuilder result = new StringBuilder();

        for (int i = 0; i < input.length(); i++) {
            char c = input.charAt(i);

            if (Character.isUpperCase(c)) {
                result.append(Character.toLowerCase(c));
            }
            else if (Character.isLowerCase(c)) {
                result.append(Character.toUpperCase(c));
            }
        }

        // 변환된 결과 출력
        System.out.println(result.toString());
    }
}

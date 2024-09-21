package bronze;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class ROT13 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String input = br.readLine();
        StringBuilder result = new StringBuilder();

        for (int i = 0; i < input.length(); i++) {
            char c = input.charAt(i);

            if (c >= 'a' && c <= 'z') {
                // 소문자 처리
                char newChar = (char) ((c - 'a' + 13) % 26 + 'a');
                result.append(newChar);
            } else if (c >= 'A' && c <= 'Z') {
                // 대문자 처리
                char newChar = (char) ((c - 'A' + 13) % 26 + 'A');
                result.append(newChar);
            } else {
                // 알파벳이 아닌 문자는 그대로
                result.append(c);
            }
        }

        System.out.println(result.toString());
    }
}

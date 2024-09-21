package bronze;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class StringAnalysis {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String input;

        while ((input = br.readLine()) != null && !input.isEmpty()) {
            int lowerCase = 0;
            int upperCase = 0;
            int digits = 0;
            int spaces = 0;

            for (int i = 0; i < input.length(); i++) {
                char c = input.charAt(i);

                if (c >= 'a' && c <= 'z') {
                    lowerCase++;  // 소문자
                } else if (c >= 'A' && c <= 'Z') {
                    upperCase++;  // 대문자
                } else if (c >= '0' && c <= '9') {
                    digits++;     // 숫자
                } else if (c == ' ') {
                    spaces++;     // 공백
                }
            }
            System.out.println(lowerCase + " " + upperCase + " " + digits + " " + spaces);
        }
    }
}

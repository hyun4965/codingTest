package bronze;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class GEZE {

    static int count = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int T = Integer.parseInt(br.readLine());
        for (int i = 0; i < T; i++) {
            String S = br.readLine();
            count = 0;
            sb.append(isPalindrome(S)).append(" ").append(count).append("\n");
        }
        br.close();
        System.out.print(sb);
    }

    static int isPalindrome(String s) {
        return recursion(s, 0, (s.length() - 1));
    }

    static int recursion(String s, int start, int end) {
        count++;

        if (start >= end) return 1;
        else if (s.charAt(start) !=  s.charAt(end)) return 0;
        else return recursion(s, (start + 1), (end - 1));
    }
}
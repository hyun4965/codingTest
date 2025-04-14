package gold;

import java.util.*;

public class BJ1759 {
    static int L, C;
    static char[] chars;
    static char[] result;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        L = sc.nextInt(); // 암호 길이
        C = sc.nextInt(); // 사용할 문자 수
        chars = new char[C];
        result = new char[L];

        for (int i = 0; i < C; i++) {
            chars[i] = sc.next().charAt(0);
        }

        Arrays.sort(chars); // 사전 순 정렬

        dfs(0, 0);
    }

    static void dfs(int start, int depth) {
        if (depth == L) {
            if (isValid(result)) {
                System.out.println(new String(result));
            }
            return;
        }

        for (int i = start; i < C; i++) {
            result[depth] = chars[i];
            dfs(i + 1, depth + 1);
        }
    }

    static boolean isValid(char[] password) {
        int vowel = 0;
        int consonant = 0;
        for (char c : password) {
            if ("aeiou".indexOf(c) >= 0) {
                vowel++;
            } else {
                consonant++;
            }
        }
        return vowel >= 1 && consonant >= 2;
    }
}

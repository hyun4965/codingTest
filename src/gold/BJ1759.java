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

    // 자음이 2개이상 모음이 1개 이상인지 판별하는 로직
    public static boolean isValid(char[] code) {
        int c = 0; // 자음의 수
        int v = 0; // 모음의 수
        for (int i = 0; i < code.length; i++) {
            if (code[i] == 'a' || code[i] == 'e' || code[i] == 'i' || code[i] == 'o' || code[i] == 'u') {
                v++; // 모음일 경우 v++
            } else {
                c++; // 자음일 경우 c++
            }
        }
        if (c >= 2 && v >= 1) {
            return true; // 자음 2개 이상, 모음 1개이상 일 경우 true 반환
        } else {
            return false; // 아닐경우 false 반환
        }
    }
}

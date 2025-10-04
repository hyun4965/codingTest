import java.util.*;

class Solution {
    private boolean isCorrect(String p) {
        Stack<Character> stack = new Stack<>();
        for (char c : p.toCharArray()) {
            if (c == '(') {
                stack.push(c);
            } else {
                if (stack.isEmpty()) {
                    return false;
                }
                stack.pop();
            }
        }
        return stack.isEmpty();
    }

    private String convert(String w) {
        if (w.isEmpty()) {
            return "";
        }

        int openCount = 0;
        int closeCount = 0;
        int splitIndex = 0;
        for (int i = 0; i < w.length(); i++) {
            if (w.charAt(i) == '(') {
                openCount++;
            } else {
                closeCount++;
            }
            if (openCount == closeCount) {
                splitIndex = i + 1;
                break;
            }
        }
        String u = w.substring(0, splitIndex);
        String v = w.substring(splitIndex);

        if (isCorrect(u)) {
            return u + convert(v);
        } else {
            StringBuilder sb = new StringBuilder();
            sb.append('(');
            sb.append(convert(v));
            sb.append(')');
            
            String middleU = u.substring(1, u.length() - 1);
            for (char c : middleU.toCharArray()) {
                if (c == '(') {
                    sb.append(')');
                } else {
                    sb.append('(');
                }
            }
            
            return sb.toString();
        }
    }

    public String solution(String p) {
        return convert(p);
    }
}
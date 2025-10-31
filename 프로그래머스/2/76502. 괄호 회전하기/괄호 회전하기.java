import java.util.Stack;

class Solution {
    
    public int solution(String s) {
        int answer = 0;
        int n = s.length();
        
        for (int i = 0; i < n; i++) {
            String rotated = s.substring(i) + s.substring(0, i);
            if (isValid(rotated)) {
                answer++;
            }
        }
        return answer;
    }
    
    private boolean isValid(String str) {
        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < str.length(); i++) {
            char c = str.charAt(i);
            if (c == '(' || c == '{' || c == '[') {
                stack.push(c);
            }else {
                if (stack.isEmpty()) {
                    return false;
                }
                
                char opener = stack.pop();
                
                if (c == ')' && opener != '(') {
                    return false;
                }
                if (c == '}' && opener != '{') {
                    return false;
                }
                if (c == ']' && opener != '[') {
                    return false;
                }
            }
        }
        
        return stack.isEmpty();
    }
}
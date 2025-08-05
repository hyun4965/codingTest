import java.util.*;
class Solution {
    public int solution(String s) {
        String[] tokens = s.split(" ");
        int sum = 0;
        Stack<Integer> stack = new Stack<>();

        for (String token : tokens) {
            if (token.equals("Z")) {
                if (!stack.isEmpty()) {
                    sum -= stack.pop();
                }
            } else {
                int num = Integer.parseInt(token);
                stack.push(num);
                sum += num;
            }
        }

        return sum;
    }
}

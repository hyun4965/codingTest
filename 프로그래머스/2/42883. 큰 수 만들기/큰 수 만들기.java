import java.util.*;

class Solution {
    public String solution(String number, int k) {
        Deque<Character> que = new ArrayDeque<>();

        for (int i = 0; i < number.length(); i++) {
            char c = number.charAt(i);

            while ( k > 0 && 
                   !que.isEmpty() && 
                   que.peekLast() < c) 
            {
                que.removeLast(); 
                k--;
            }
            que.addLast(c); 
        }

        while (k > 0 && !que.isEmpty()) {
            que.removeLast();
            k--;
        }

        StringBuilder sb = new StringBuilder(que.size());
        for (char ch : que) {
            sb.append(ch);
        }

        return sb.toString();
    }
}

import java.util.*;

class Solution {
    public String solution(String s, String skip, int index) {
        
        StringBuilder answer = new StringBuilder();

        Set<Character> set = new HashSet<>();
        
        for (char c : skip.toCharArray()) {
            set.add(c);
        }

        for (char ch : s.toCharArray()) {
            int count = 0;
            char cur = ch;

            while (count < index) {
                cur++;

                if (cur > 'z') {
                    cur = 'a';
                }

                if (!set.contains(cur)) {
                    count++;
                }
            }

            answer.append(cur);
        }

        return answer.toString();
    }
}

import java.util.HashSet;

class Solution {
    public String solution(String my_string) {
        StringBuilder answer = new StringBuilder();
        HashSet<Character> seen = new HashSet<>();

        for (char c : my_string.toCharArray()) {
            if (!seen.contains(c)) {
                seen.add(c);
                answer.append(c);
            }
        }

        return answer.toString();
    }
}

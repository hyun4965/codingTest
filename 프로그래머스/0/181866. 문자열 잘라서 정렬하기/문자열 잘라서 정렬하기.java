import java.util.*;

class Solution {
    public String[] solution(String myString) {
        String[] split = myString.split("x");

        List<String> list = new ArrayList<>();
        for (String s : split) {
            if (!s.isEmpty()) {
                list.add(s);
            }
        }

        String[] answer = list.toArray(new String[0]);
        Arrays.sort(answer);

        return answer;
    }
}

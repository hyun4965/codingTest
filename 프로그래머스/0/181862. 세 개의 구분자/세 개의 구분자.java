import java.util.*;

class Solution {
    public String[] solution(String myStr) {
        String[] splitArr = myStr.split("[abc]");

        List<String> result = new ArrayList<>();
        for (String s : splitArr) {
            if (!s.isEmpty()) {
                result.add(s);
            }
        }

        if (result.isEmpty()) {
            return new String[]{"EMPTY"};
        }

        return result.toArray(new String[0]);
    }
}

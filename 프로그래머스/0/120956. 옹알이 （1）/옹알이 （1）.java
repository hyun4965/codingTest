import java.util.*;

class Solution {
    public int solution(String[] babbling) {
        String[] syll = {"aya", "ye", "woo", "ma"};
        Set<String> valid = new HashSet<>();

        boolean[] used = new boolean[4];
        dfsBuild(syll, used, new StringBuilder(), 0, valid);

        int answer = 0;
        for (String w : babbling) {
            if (valid.contains(w)) answer++;
        }
        return answer;
    }

    private void dfsBuild(String[] syll, boolean[] used, StringBuilder sb, int depth, Set<String> valid) {
        if (depth > 0) { 
            valid.add(sb.toString());
        }
        if (depth == 4) return; 

        for (int i = 0; i < 4; i++) {
            if (used[i]) continue;
            used[i] = true;
            int prevLen = sb.length();
            sb.append(syll[i]);
            dfsBuild(syll, used, sb, depth + 1, valid);
            sb.setLength(prevLen);
            used[i] = false;
        }
    }
}

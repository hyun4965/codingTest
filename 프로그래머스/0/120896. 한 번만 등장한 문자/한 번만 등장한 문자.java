import java.util.*;

class Solution {
    public String solution(String s) {
        int[] count = new int[26]; 

        for (char c : s.toCharArray()) {
            count[c - 'a']++;
        }

        StringBuilder result = new StringBuilder();
        for (int i = 0; i < 26; i++) {
            if (count[i] == 1) {
                result.append((char)(i + 'a'));
            }
        }

        return result.toString(); 
    }
}

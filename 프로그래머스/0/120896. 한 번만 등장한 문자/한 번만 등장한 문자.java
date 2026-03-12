import java.util.Arrays;

class Solution {
    public String solution(String s) {
        String answer = "";

        for(int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);

            if(s.indexOf(c) == s.lastIndexOf(c)) {
                answer += c;
            }
        }

        char[] arr = answer.toCharArray();
        Arrays.sort(arr);

        return new String(arr);
    }
}
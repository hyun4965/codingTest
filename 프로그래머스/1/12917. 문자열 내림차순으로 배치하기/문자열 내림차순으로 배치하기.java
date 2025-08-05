import java.util.Arrays;

class Solution {
    public String solution(String s) {
        char[] arr = s.toCharArray();
        Arrays.sort(arr);
        String sortedString = new String(arr);
        
        StringBuilder sb = new StringBuilder(sortedString);
        return sb.reverse().toString();
    }
}

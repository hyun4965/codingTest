import java.util.*;

class Solution {
    public String solution(String X, String Y) {

        int[] xCount = new int[10]; 
        int[] yCount = new int[10];

        for (char c : X.toCharArray()) {
            xCount[c - '0']++;
        }
        for (char c : Y.toCharArray()) {
            yCount[c - '0']++;
        }
        
        StringBuilder sb = new StringBuilder();

        for (int i = 9; i >= 0; i--) {
            int minCount = Math.min(xCount[i], yCount[i]);
            for (int j = 0; j < minCount; j++) {
                sb.append(i);
            }
        }
        
        String answer = sb.toString();

        if (answer.isEmpty()) {
            return "-1";
        } else if (answer.startsWith("0")) {
            return "0";
        } else {
            return answer;
        }
    }
}
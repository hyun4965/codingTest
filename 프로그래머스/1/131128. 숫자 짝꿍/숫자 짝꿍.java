import java.util.*;

class Solution {
    public String solution(String X, String Y) {
        StringBuilder answer = new StringBuilder();
        
        int[] countX = new int[10];
        int[] countY = new int[10];

        for (char c : X.toCharArray()) {
            countX[c - '0']++;
        }
        for (char c : Y.toCharArray()) {
            countY[c - '0']++;
        }

        for (int i = 9; i >= 0; i--) {
            int m = Math.min(countX[i], countY[i]);
            for (int j = 0; j < m; j++) {
                answer.append(i);
            }
        }

        if (answer.length() == 0) {
            return "-1";
        }
        if (answer.charAt(0) == '0') {
            return "0";
        }
        
        return answer.toString();
    }
}
import java.util.*;

class Solution {
    public int solution(int n, int m, int[] section) {
        int answer = 1; 
        
        int start = section[0] + m - 1;
        
        for (int i = 1; i < section.length; i++) {
            int cur = section[i];
            
            if (cur > start) {
                answer++;
                start = cur + m - 1;
            }
        }
        
        return answer;
    }
}
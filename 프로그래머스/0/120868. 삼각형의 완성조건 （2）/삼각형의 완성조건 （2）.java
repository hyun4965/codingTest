import java.util.*;
class Solution {
    public int solution(int[] sides) {
        int answer = 0;
        Arrays.sort(sides);
        int max = sides[1];
        int min = sides[0];
        
        for (int i = max - min; i < max; i++) {
            answer++;
        }
        for (int i = max + min - 1; i > max; i--) {
            answer++;
        }
        return answer;
    }
}
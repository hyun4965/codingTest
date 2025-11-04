import java.util.*;

class Solution {
    public int solution(int[][] lines) {

        int[] lineMap = new int[200];
        
        for (int[] line : lines) {
            int start = line[0];
            int end = line[1];

            for (int i = start; i < end; i++) {
                lineMap[i + 100]++;
            }
        }
        
        int answer = 0;
        for (int count : lineMap) {
            if (count >= 2) {
                answer++;
            }
        }
        return answer;
    }
}
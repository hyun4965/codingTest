import java.util.*;

class Solution {
    public int[] solution(int[] arr, int[][] intervals) {
        List<Integer> list = new ArrayList<>();
        
        for (int[] interval : intervals) {
            int start = interval[0];
            int end = interval[1];
            
            for (int i = start; i <= end; i++) {
                list.add(arr[i]);
            }
        }
        
        int[] answer = new int[list.size()];
        for (int i = 0; i < list.size(); i++) {
            answer[i] = list.get(i);
        }
        
        return answer;
    }
}

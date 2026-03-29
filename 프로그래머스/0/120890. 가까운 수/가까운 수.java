import java.util.*;

class Solution {
    public int solution(int[] array, int n) {
        int answer = 0;
        int diff = Integer.MAX_VALUE;
        Arrays.sort(array);
        
        for(int i = 0; i < array.length; i++){
            int cur = Math.abs(array[i] - n);
            
            if(cur < diff){
                diff = cur;
                answer = array[i];
            }
        }
        
        return answer;
    }
}
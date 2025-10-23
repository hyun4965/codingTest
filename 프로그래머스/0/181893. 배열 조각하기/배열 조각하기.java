import java.util.*;

class Solution {
    public int[] solution(int[] arr, int[] query) {
        int[] answer = arr;
        
        for(int i=0; i<query.length; i++){
            int index = query[i];
            
            if(i % 2 == 0){
                answer = Arrays.copyOfRange(answer,0,index+1);
            }else{
                answer = Arrays.copyOfRange(answer,index,answer.length);
            }
        }
        return answer;
    }
}
import java.util.*;

class Solution {
    public int[] solution(int[] num_list) {
        Arrays.sort(num_list); 

        int size = num_list.length - 5;
        int[] answer = new int[size];

        for (int i = 0; i < size; i++) {
            answer[i] = num_list[i + 5];  
        }

        return answer;
    }
}

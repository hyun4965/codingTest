import java.util.*;

class Solution {
    public int[] solution(String my_string) {
        List<Integer> nums = new ArrayList<>();
        
        for (char ch : my_string.toCharArray()) {
            if (Character.isDigit(ch)) {
                nums.add(ch - '0'); 
            }
        }
        
        Collections.sort(nums);
        
        int[] answer = new int[nums.size()];
        for (int i = 0; i < nums.size(); i++) {
            answer[i] = nums.get(i);
        }
        
        return answer;
    }
}

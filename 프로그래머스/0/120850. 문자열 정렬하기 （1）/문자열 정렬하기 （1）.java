import java.util.*;

class Solution {
    public int[] solution(String my_string) {
        List<Character> list = new ArrayList<>();
        
        for (int i = 0; i < my_string.length(); i++) {
            char c = my_string.charAt(i);
            if (c >= '0' && c <= '9') {
                list.add(c);
            }
        }

        List<Integer> nums = new ArrayList<>();
        for (char c : list) {
            nums.add(c - '0');
        }

        Collections.sort(nums);

        int[] answer = new int[nums.size()];
        for (int i = 0; i < nums.size(); i++) {
            answer[i] = nums.get(i);
        }

        return answer;
    }
}

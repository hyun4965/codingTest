import java.util.*;

class Solution {
    public int solution(int[] nums) {
        int num = nums.length / 2;
        
        Set<Integer> set = new HashSet<Integer>();
        
        for (int i=0; i < nums.length; i++) {
            set.add(nums[i]);
        }
        
        int pokemon_nums = set.size();
        
        if (pokemon_nums <= num) {
            return pokemon_nums;
        } else {
            return num;
        }
    }
}
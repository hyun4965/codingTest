import java.util.*;

class Solution {
    int answer = 0;

    public int solution(int[] nums) {
        dfs(0, 0, 0, nums);
        return answer;
    }

    
    void dfs(int start, int count, int sum, int[] nums) {
        if (count == 3) {
            if (isPrime(sum)) {
                answer++; 
            }
            return; 
        }
        
        for (int i = start; i < nums.length; i++) {
            dfs(i + 1, count + 1, sum + nums[i], nums);
        }
    }

    
    boolean isPrime(int num) {
        if (num <= 1) {
            return false;
        }
        for (int i = 2; i * i <= num; i++) {
            if (num % i == 0) { 
                return false;
            }
        }
        return true;
    }
}
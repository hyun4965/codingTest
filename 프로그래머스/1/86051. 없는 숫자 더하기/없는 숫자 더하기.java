import java.util.HashSet;
import java.util.Set;

class Solution {
    public int solution(int[] numbers) {
        int answer = 0;
        Set<Integer> set = new HashSet<>();
        
        for (int num : numbers) {
            set.add(num);
        }
        
        for (int i = 0; i <= 9; i++) {
            if (!set.contains(i)) {
                answer += i;
            }
        }
        
        return answer;
    }
}

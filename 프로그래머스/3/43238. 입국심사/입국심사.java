import java.util.Arrays;

class Solution {
    public long solution(int n, int[] times) {
        long answer = 0;
        
        Arrays.sort(times);
        
        long left = 1;
        long right = (long) times[times.length - 1] * n;
        
        while (left <= right) {
            long mid = (left + right) / 2;
            long count = 0; //n과 비교군 
            
            for (int time : times) {
                count += mid / time; //몇명인지 체크
            }
            
            if (count >= n) {
                answer = mid; 
                right = mid - 1;
            }  else {
                left = mid + 1;
            }
        }
        
        return answer;
    }
}
import java.util.Arrays;

class Solution {
    public long solution(int n, int[] times) {
        Arrays.sort(times);

        long left = 1; // 최소 시간
        long right = (long) n * times[times.length - 1]; 
        
        long answer = right; 

        while (left <= right) {
            long mid = left + (right - left) / 2;
            long count = 0; 

            for (int time : times) {
                count += mid / time;
            }

            if (count >= n) {
                answer = mid;
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }

        return answer;
    }
}
class Solution {
    public long solution(int[] sequence) {

        long answer = Long.MIN_VALUE;
        long dp1 = 0;
        long dp2 = 0;
        
        int pulse = 1;

        for (int num : sequence) {
            long val1 = num * pulse;
            long val2 = num * -pulse;

            dp1 = Math.max(val1, dp1 + val1);
            dp2 = Math.max(val2, dp2 + val2);

            answer = Math.max(answer, Math.max(dp1, dp2));
            
            pulse *= -1;
        }
        
        return answer;
    }
}
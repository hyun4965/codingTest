class Solution {
    public long solution(int[] sequence) {
        long answer = 0;
        
        long sum1 = 0;
        long sum2 = 0;
        
        int pulse = 1;
    
        answer = Long.MIN_VALUE; 

        for (int num : sequence) {
            long val1 = num * pulse; 
            long val2 = num * (-pulse);   
            
            sum1 = Math.max(sum1 + val1, val1);
            sum2 = Math.max(sum2 + val2, val2);
            
            long maxCurrent = Math.max(sum1, sum2);
            answer = Math.max(answer, maxCurrent);
            
            pulse *= -1;
        }
        
        return answer;
    }
}
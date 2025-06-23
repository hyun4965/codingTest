class Solution {
    public int solution(int[] numbers, int n) {
        int answer = 0;

        for (int value : numbers) {   
            answer += value;          
            if (answer > n) {        
                return answer;           
            }
        }
        return answer;
    }
}

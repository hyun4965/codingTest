class Solution {
    // a개의 빈병 -> b개의 콜라, 처음 가진 빈병 n개
    public int solution(int a, int b, int n) {
        int answer = 0;
        
        while (n >= a) { 
            int exchangeCount = n / a;   
            int received = exchangeCount * b; 

            answer += received;

            n = n % a;
            n += received;
        }
        
        return answer;
    }
}

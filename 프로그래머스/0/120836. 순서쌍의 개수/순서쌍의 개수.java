class Solution {
    public int solution(int n) {
        int answer = 0;

        for (int d = 1; d * d <= n; d++) {
            if (n % d == 0) {         
                int pair = n / d;    

                if (d == pair) {      
                    answer += 1;
                } else {     
                    answer += 2;
                }
            }
        }
        return answer;
    }
}

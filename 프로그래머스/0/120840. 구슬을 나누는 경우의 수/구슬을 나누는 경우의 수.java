class Solution {
    public int solution(int balls, int share) {
        long answer = 1;

        if (share > balls / 2) {
            share = balls - share;
        }

        for (int i = 0; i < share; i++) {
            answer = answer * (balls - i);
            answer = answer / (i + 1);
        }
        
        return (int) answer;
    }
}
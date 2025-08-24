class Solution {
    public int[] solution(int n, int s) {

        if (s < n) {
            return new int[]{-1};
        }
        
        int[] answer = new int[n];

        int base = s / n; 
        int r = s % n;    
        
        for (int i = 0; i < n; i++) {
            answer[i] = base;
        }
        
        for (int i = n - r; i < n; i++) {
            if (i >= 0) {
                answer[i]++; 
            }
        }

        return answer;
    }
}

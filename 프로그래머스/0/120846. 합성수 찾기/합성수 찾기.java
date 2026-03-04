class Solution {
    public int solution(int n) {
        int answer = 0;
        for (int i = 1; i <= n; i++) {
            if (isComposite(i)) {
                answer++;
            }
        }
        return answer;
    }

    static boolean isComposite(int x) {
        if (x < 4) {
            return false; 
        }
        for (int i = 2; i * i <= x; i++) {
            if (x % i == 0) {
                return true;
            }
        }
        return false;
    }
}
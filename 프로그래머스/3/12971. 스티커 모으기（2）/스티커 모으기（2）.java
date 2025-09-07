class Solution {
    public int solution(int[] sticker) {
        int n = sticker.length;
        if (n == 1) return sticker[0]; 

        int prev2 = 0, prev1 = 0;
        for (int i = 0; i < n - 1; i++) {
            int take = prev2 + sticker[i]; 
            int skip = prev1;
            int cur  = Math.max(take, skip);
            prev2 = prev1;
            prev1 = cur;
        }
        int case1 = prev1;

        prev2 = 0; prev1 = 0;
        for (int i = 1; i < n; i++) {
            int take = prev2 + sticker[i];
            int skip = prev1;
            int cur  = Math.max(take, skip);
            prev2 = prev1;
            prev1 = cur;
        }
        int case2 = prev1;

        return Math.max(case1, case2);
    }
}

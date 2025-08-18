class Solution {
    public int solution(int n) {
        final int MOD = 1_000_000_007;

        if (n == 1) return 1;   
        if (n == 2) return 2;   

        long prev2 = 1;
        long prev1 = 2; 
        long cur = 0;

        for (int i = 3; i <= n; i++) {
            cur = (prev1 + prev2) % MOD; // f(n) = f(n-1) + f(n-2)
            prev2 = prev1;
            prev1 = cur;
        }

        return (int) cur;
    }
}

class Solution {
    public int solution(int n) {
        int g = gcd(n, 6);
        return n / g;
    }

    private int gcd(int a, int b) {
        while (b != 0) {
            int r = a % b;
            a = b;
            b = r;
        }
        return a;
    }
}
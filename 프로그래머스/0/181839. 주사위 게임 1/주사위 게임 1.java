class Solution {
    public int solution(int a, int b) {
        boolean aOdd = (a & 1) == 1;
        boolean bOdd = (b & 1) == 1;

        if (aOdd && bOdd) {
            return a * a + b * b;
        } else if (aOdd ^ bOdd) {
            return 2 * (a + b);
        } else {
            return Math.abs(a - b);
        }
    }
}

class Solution {
    public int solution(int[] sides) {
        int a = sides[0];
        int b = sides[1];

        return Math.min(a, b) * 2 - 1;
    }
}
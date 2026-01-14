class Solution {
    public int solution(int[] sides) {
        
        int max = 0;
        int sum = 0;

        for (int s : sides) {
            max = Math.max(max, s);
            sum += s;
        }

        return (sum - max > max) ? 1 : 2;
    }
}
class Solution {
    public String solution(int n, int t, int m, int p) {
        StringBuilder nums = new StringBuilder();
        StringBuilder answer = new StringBuilder();

        for (int i = 0; nums.length() < t * m; i++) {
            nums.append(Integer.toString(i, n).toUpperCase());
        }

        for (int i = p - 1; answer.length() < t; i += m) {
            answer.append(nums.charAt(i));
        }

        return answer.toString();
    }
}
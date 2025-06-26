class Solution {
    public String solution(int[] numLog) {
        StringBuilder sb = new StringBuilder();

        for (int i = 1; i < numLog.length; i++) {
            int n = numLog[i] - numLog[i - 1];

            if (n == 1) {
                sb.append('w');
            } else if (n == -1) {
                sb.append('s');
            } else if (n == 10) {
                sb.append('d');
            } else if (n == -10) {
                sb.append('a');
            }
        }

        return sb.toString();
    }
}

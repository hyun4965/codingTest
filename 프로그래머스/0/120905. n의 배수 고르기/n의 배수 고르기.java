class Solution {
    public int[] solution(int n, int[] numlist) {
        int cnt = 0;
        for (int x : numlist) {
            if (x % n == 0) {
                cnt++;
            }
        }

        int[] answer = new int[cnt];
        int idx = 0;
        for (int x : numlist) {
            if (x % n == 0) {
                answer[idx++] = x;
            }
        }

        return answer;
    }
}

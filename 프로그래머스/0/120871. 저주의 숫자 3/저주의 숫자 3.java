class Solution {
    public int solution(int n) {
        int count = 0;
        int answer = 0;

        while (count < n) {
            answer++;
            if (answer % 3 == 0 || String.valueOf(answer).contains("3")) {
                continue;
            }
            count++;
        }

        return answer;
    }
}

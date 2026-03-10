class Solution {
    public int solution(String[] strArr) {
        int[] count = new int[31];
        int answer = 0;
        
        for (String str : strArr) {
            int len = str.length();
            count[len]++;
            answer = Math.max(answer, count[len]);
        }
        
        return answer;
    }
}
class Solution {
    public int solution(int i, int j, int k) {
        int answer = 0;
        String kStr = String.valueOf(k);
        
        for (int start = i; start <= j; start++) {
            String numStr = String.valueOf(start);
            for (int index = 0; index < numStr.length(); index++) {
                if (numStr.charAt(index) == kStr.charAt(0)) {
                    answer++;
                }
            }
        }
        
        return answer;
    }
}

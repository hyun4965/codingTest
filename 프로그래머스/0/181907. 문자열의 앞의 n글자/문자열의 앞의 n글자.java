class Solution {
    public String solution(String my_string, int n) {
        StringBuilder answer = new StringBuilder();
        
        for(int i=0; i<n; i++){
            char c = my_string.charAt(i);
            answer.append(c);
        }
        
        return answer.toString();
    }
}
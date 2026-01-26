class Solution {
    public String solution(String cipher, int code) {
        StringBuilder answer = new StringBuilder();
        
        for(int i=code-1; i<cipher.length(); i+=code){
            char c = cipher.charAt(i);
            answer.append(c);
        }
        
        return answer.toString();
    }
}
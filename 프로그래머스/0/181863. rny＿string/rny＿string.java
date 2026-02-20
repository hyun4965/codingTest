class Solution {
    public String solution(String rny_string) {
        StringBuilder answer = new StringBuilder();
        
        for(int i=0; i<rny_string.length(); i++){
            char c = rny_string.charAt(i);
            if(c == 'm'){
                answer.append('r').append('n');
                continue;
            }
            answer.append(c);
        }
        
        return answer.toString();
    }
}
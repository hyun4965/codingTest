class Solution {
    public String solution(String my_string, String alp) {
        StringBuilder answer = new StringBuilder();
        
        for(int i=0; i<my_string.length(); i++ ){
            char c = my_string.charAt(i);
            if( c == alp.charAt(0)){
                answer.append(alp.toUpperCase());
                continue;
            }
            answer.append(c);
        }
        
        return answer.toString();
    }
}
class Solution {
    public String solution(String n_str) {
        StringBuilder answer = new StringBuilder();
        boolean flag = false;
        int zeroCount = 0;
        for(int i=0; i<n_str.length();i++){
            char c = n_str.charAt(i);
            if(c == '0'){
                zeroCount++;
            }else{
                break;
            }
        }
        for(int i=zeroCount; i<n_str.length(); i++){
            char c = n_str.charAt(i);
            answer.append(c);
        }
        
        return answer.toString();
    }
}
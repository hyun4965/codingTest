class Solution {
    public String solution(String rsp) {
        StringBuilder answer = new StringBuilder();
        
        for(int i=0; i<rsp.length(); i++){
            char c = rsp.charAt(i);
            if(c=='2'){
                answer.append(0);
            }else if(c=='0'){
                answer.append(5);
            }else{
                answer.append(2);
            }
        }
        
        return answer.toString();
    }
}
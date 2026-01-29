class Solution {
    public String solution(String myString) {
        StringBuilder answer = new StringBuilder();
        for(int i=0; i<myString.length(); i++){
            char c = myString.charAt(i);
            if(c > 'l'){
                answer.append(c);
            }else{
                answer.append('l');
            }
        }
        return answer.toString();
    }
}
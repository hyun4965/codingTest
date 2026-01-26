class Solution {
    public String solution(String my_string, int num1, int num2) {
        StringBuilder answer = new StringBuilder();
        
        char str1 = my_string.charAt(num1);
        char str2 = my_string.charAt(num2);
        
        for(int i=0; i<my_string.length(); i++){
            if(i == num1){
                answer.append(str2);
            }else if(i == num2){
                answer.append(str1);
            }else{
                char c = my_string.charAt(i);
                answer.append(c);
            }
        }
        
        return answer.toString();
    }
}
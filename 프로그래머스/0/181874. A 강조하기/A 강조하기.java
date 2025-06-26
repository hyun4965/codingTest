class Solution {
    public String solution(String myString) {
        StringBuilder answer = new StringBuilder();
        
        for (int i = 0; i < myString.length(); i++) {
            char c = myString.charAt(i);
            
            if (c == 'a') {
                answer.append('A'); 
            } else if (Character.isUpperCase(c) && c != 'A') {
                answer.append(Character.toLowerCase(c)); 
            } else {
                answer.append(c);
            }
        }
        
        return answer.toString();
    }
}

class Solution {
    public String solution(String my_string, String alp) {
        StringBuilder answer = new StringBuilder();
        
        char target = alp.charAt(0);
        
        for (int i = 0; i < my_string.length(); i++) {
            char c = my_string.charAt(i);
            
            if (c == target) {
                answer.append(Character.toUpperCase(c));
            } else {
                answer.append(c);
            }
        }
        
        return answer.toString();
    }
}

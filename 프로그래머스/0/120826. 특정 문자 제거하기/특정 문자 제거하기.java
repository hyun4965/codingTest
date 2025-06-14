class Solution {
    public String solution(String my_string, String letter) {
        StringBuilder sb = new StringBuilder();
        
        for (int i = 0; i < my_string.length(); i++) {
            char c = my_string.charAt(i);
            if (c == letter.charAt(0)) {
                continue;
            } else {
                sb.append(c);
            }
        }
        
        return sb.toString();
    }
}

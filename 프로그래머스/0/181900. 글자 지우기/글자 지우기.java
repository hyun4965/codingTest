class Solution {
    public String solution(String my_string, int[] indices) {
        StringBuilder answer = new StringBuilder();
        
        boolean[] remove = new boolean[my_string.length()];
        
        for (int idx : indices) {
            remove[idx] = true;
        }
        
        for (int i = 0; i < my_string.length(); i++) {
            if (!remove[i]) {
                answer.append(my_string.charAt(i));
            }
        }
        
        return answer.toString();
    }
}
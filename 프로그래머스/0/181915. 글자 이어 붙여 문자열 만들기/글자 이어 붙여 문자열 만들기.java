class Solution {
    public String solution(String my_string, int[] index_list) {
        StringBuilder answer = new StringBuilder();
        
        for(int i=0; i<index_list.length; i++){
            char c = my_string.charAt(index_list[i]);
            answer.append(c);
        }
        
        return answer.toString();
    }
}
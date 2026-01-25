class Solution {
    public String solution(String[] arr) {
        StringBuilder answer = new StringBuilder();
        
        for(int i=0; i<arr.length; i++){
            char c = arr[i].charAt(0);
            answer.append(c);
        }
        
        return answer.toString();
    }
}
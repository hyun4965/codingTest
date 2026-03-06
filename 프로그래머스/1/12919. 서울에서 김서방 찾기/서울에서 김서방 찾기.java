class Solution {
    public String solution(String[] seoul) {
        StringBuilder answer = new StringBuilder();
        int index = -1;
        for(int i=0; i<seoul.length; i++){
            if(seoul[i].equals("Kim")){
                index = i;
                break;
            }
        }
        answer.append("김서방은 ").append(index).append("에 있다");
        return answer.toString();
    }
}
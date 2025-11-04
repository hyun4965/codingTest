class Solution {
    public String[] solution(String[] quiz) {
        String[] answer = new String[quiz.length];
        
         for (int i = 0; i < quiz.length; i++) {
             String[] str = quiz[i].split(" ");
             int first = Integer.parseInt(str[0]);
             int second = Integer.parseInt(str[2]);
             int third = Integer.parseInt(str[4]);
             if ((quiz[i].contains(" + ") && first + second == third) ||
                     (quiz[i].contains(" - ") && first - second == third)) {
                 answer[i] = "O";
             } else {
                 answer[i] = "X";
             }
         }
        
         return answer;
    }
}
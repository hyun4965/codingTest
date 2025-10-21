class Solution {
    public String solution(String[] id_pw, String[][] db) {
        String answer = "fail";

        for (String[] member : db) {
            String memberId = member[0];
            String memberPw = member[1];

            if (id_pw[0].equals(memberId)) {
                if (id_pw[1].equals(memberPw)) {
                    return "login";
                } else {
                    answer = "wrong pw";
                    break;
                }
            }
        }
        
        return answer;
    }
}
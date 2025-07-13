class Solution {
    public String solution(String phone_number) {
        int len = phone_number.length();
        StringBuilder answer = new StringBuilder();

        for (int i = 0; i < len - 4; i++) {
            answer.append("*");
        }

        answer.append(phone_number.substring(len - 4));

        return answer.toString();
    }
}

class Solution {
    public String solution(int age) {
        StringBuilder answer = new StringBuilder();
        String ageStr = String.valueOf(age);

        for (int i = 0; i < ageStr.length(); i++) {
            int digit = ageStr.charAt(i) - '0'; 
            answer.append((char) ('a' + digit)); 
        }

        return answer.toString();
    }
}

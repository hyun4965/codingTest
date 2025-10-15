class Solution {
    public String solution(String s) {
        s = s.toLowerCase(); 
        String answer = "";
        boolean isFirstChar = true;

        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);

            if (isFirstChar) {
                if (Character.isAlphabetic(c)) {
                    answer += Character.toUpperCase(c);
                } else {
                    answer += c;
                }
                isFirstChar = false;
            } else {
                answer += c;
            }

            if (c == ' ') {
                isFirstChar = true;
            }
        }

        return answer;
    }
}

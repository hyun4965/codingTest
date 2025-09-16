class Solution {
    public String solution(String new_id) {
        String answer = new_id.toLowerCase();

        StringBuilder step2 = new StringBuilder();
        for (char c : answer.toCharArray()) {
            if ((c >= 'a' && c <= 'z') || (c >= '0' && c <= '9') || c == '-' || c == '_' || c == '.') {
                step2.append(c);
            }
        }
        answer = step2.toString();

        while (answer.contains("..")) {
            answer = answer.replace("..", ".");
        }

        if (!answer.isEmpty() && answer.startsWith(".")) {
            answer = answer.substring(1);
        }
        if (!answer.isEmpty() && answer.endsWith(".")) {
            answer = answer.substring(0, answer.length() - 1);
        }

        if (answer.isEmpty()) {
            answer = "a";
        }

        if (answer.length() >= 16) {
            answer = answer.substring(0, 15);
            if (answer.endsWith(".")) {
                answer = answer.substring(0, answer.length() - 1);
            }
        }

        StringBuilder step7 = new StringBuilder(answer);
        while (step7.length() <= 2) {
            step7.append(step7.charAt(step7.length() - 1));
        }
        answer = step7.toString();
        
        return answer;
    }
}
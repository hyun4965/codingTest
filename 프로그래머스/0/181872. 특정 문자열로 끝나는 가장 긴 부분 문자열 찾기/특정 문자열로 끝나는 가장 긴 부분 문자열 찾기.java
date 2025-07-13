class Solution {
    public String solution(String myString, String pat) {
        String answer = "";
        for (int i = 1; i <= myString.length(); i++) {
            String sub = myString.substring(0, i);
            if (sub.endsWith(pat)) {
                answer = sub;
            }
        }
        return answer;
    }
}

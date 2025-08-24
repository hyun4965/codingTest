class Solution {
    public int solution(String s) {
        int answer = 0;
        int same = 0; 
        int diff = 0; 

        char x = s.charAt(0); 

        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);

            if (ch == x) {
                same++;
            } else {
                diff++;
            }

            if (same == diff) {
                answer++;

                if (i + 1 < s.length()) {
                    x = s.charAt(i + 1);
                }
                same = 0;
                diff = 0;
            }
        }

        if (same != 0 || diff != 0) {
            answer++;
        }

        return answer;
    }
}

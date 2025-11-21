class Solution {
    public String solution(String p) {
        if (p.isEmpty()) {
            return "";
        }

        String u = "";
        String v = "";
        int left = 0;
        int right = 0;

        for (int i = 0; i < p.length(); i++) {
            if (p.charAt(i) == '(') {
                left++;
            } else {
                right++;
            }
            if (left == right) {
                u = p.substring(0, i + 1);
                v = p.substring(i + 1);
                break;
            }
        }

        if (isCorrect(u)) {
            return u + solution(v); 
        } else {
            StringBuilder sb = new StringBuilder();
            
            sb.append("(");
            
            sb.append(solution(v));
            
            sb.append(")");

            String uSub = u.substring(1, u.length() - 1);
            for (int i = 0; i < uSub.length(); i++) {
                if (uSub.charAt(i) == '(') {
                    sb.append(")");
                } else {
                    sb.append("(");
                }
            }
            
            return sb.toString();
        }
    }

    private boolean isCorrect(String s) {
        int count = 0;
        for (char c : s.toCharArray()) {
            if (c == '(') {
                count++;
            } else {
                count--;
            }
            if (count < 0) return false;
        }
        return count == 0; 
    }
}
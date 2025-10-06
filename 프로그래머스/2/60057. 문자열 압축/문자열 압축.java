import java.util.*;

class Solution {
    public int solution(String s) {
        int n = s.length();
        if (n == 1) {
            return 1;
        }
        int answer = n;

        for (int unit = 1; unit <= n / 2; unit++) {
            int len = 0;              
            String prev = s.substring(0, unit);
            int count = 1;

            for (int i = unit; i < n; i += unit) {
                int end = Math.min(i + unit, n);
                String cur = s.substring(i, end);

                if (prev.equals(cur)) {
                    count++;
                } else {
                    if (count > 1) {
                        int c = count;
                        while (c > 0) { len++; c /= 10; }
                    }
                    len += prev.length();

                    prev = cur;
                    count = 1;
                }
            }

            if (count > 1) {
                int c = count;
                while (c > 0) { len++; c /= 10; }
            }
            len += prev.length();

            answer = Math.min(answer, len);
        }

        return answer;
    }
}

import java.util.*;

class Solution {
    public String solution(int[] numbers) {
        StringBuilder answer = new StringBuilder();

        String[] numStrs = new String[numbers.length];
        
        for (int i = 0; i < numbers.length; i++) {
            numStrs[i] = Integer.toString(numbers[i]);
        }

        Arrays.sort(numStrs, (a, b) -> (b + a).compareTo(a + b));

        if (numStrs[0].equals("0")) {
            return "0";
        }
        
        for (String s : numStrs) {
            answer.append(s);
        }

        return answer.toString();
    }
}

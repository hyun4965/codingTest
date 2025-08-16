import java.util.*;

class Solution {
    public int[] solution(String[] keymap, String[] targets) {
        int[] answer = new int[targets.length];
        int[] minPress = new int[26];
        Arrays.fill(minPress, -1);

        for (String key : keymap) {
            for (int i = 0; i < key.length(); i++) {
                int idx = key.charAt(i) - 'A';
                int cost = i + 1;

                if (minPress[idx] == -1 || cost < minPress[idx]) {
                    minPress[idx] = cost;
                }
            }
        }


        for (int t = 0; t < targets.length; t++) {
            String target = targets[t];
            int sum = 0;
            boolean possible = true;

            for (int i = 0; i < target.length(); i++) {
                int idx = target.charAt(i) - 'A';
                int cost = minPress[idx];

                if (cost == -1) { 
                    possible = false;
                    break;
                }
                sum += cost;
            }
            if(possible){
                answer[t] = sum;
            }else{
                answer[t] = -1;
            }

        }

        return answer;
    }
}

import java.util.*;

class Solution {
    public int[] solution(int[] progresses, int[] speeds) {
        int n = progresses.length;
        int[] days = new int[n];

        for (int i = 0; i < n; i++) {
            int remain = 100 - progresses[i];
            days[i] = (remain + speeds[i] - 1) / speeds[i];
        }

        List<Integer> batches = new ArrayList<>();
        int releaseDay = days[0];
        int cnt = 1;

        for (int i = 1; i < n; i++) {
            if (days[i] <= releaseDay) {
                cnt++;
            } else {
                batches.add(cnt);
                releaseDay = days[i];
                cnt = 1;
            }
        }
        batches.add(cnt); 

        int[] answer = new int[batches.size()];
        for (int i = 0; i < batches.size(); i++) answer[i] = batches.get(i);
        return answer;
    }
}

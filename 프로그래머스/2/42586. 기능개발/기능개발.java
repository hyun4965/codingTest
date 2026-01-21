import java.util.*;

class Solution {
    public int[] solution(int[] progresses, int[] speeds) {
        List<Integer> list = new ArrayList<>();
        Deque<Integer> queue = new ArrayDeque<>(); 
        
        for (int i = 0; i < progresses.length; i++) {
            int remain = 100 - progresses[i];
            int days = (remain + speeds[i] - 1) / speeds[i]; 
            queue.addLast(days);
        }

        while (!queue.isEmpty()) {
            int num = queue.pollFirst();
            int count = 1;

            while (!queue.isEmpty() && queue.peekFirst() <= num) {
                queue.pollFirst();
                count++;
            }

            list.add(count);
        }

        int[] answer = new int[list.size()];
        for (int i = 0; i < list.size(); i++) {
            answer[i] = list.get(i);
        }
        return answer;
    }
}

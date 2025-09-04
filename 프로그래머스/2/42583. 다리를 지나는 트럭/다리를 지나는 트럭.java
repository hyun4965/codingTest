import java.util.*;

class Solution {
    public int solution(int bridge_length, int weight, int[] truck_weights) {
        Deque<Integer> waiting = new ArrayDeque<>();
        
        for (int i : truck_weights) {
            waiting.addLast(i);
        }

        Deque<Integer> bridge = new ArrayDeque<>();

        int answer = 0; 
        int sum = 0; 

        while (!waiting.isEmpty() || sum > 0) {
            answer++;

            if (bridge.size() == bridge_length) {
                sum -= bridge.pollFirst();
            }

            if (!waiting.isEmpty()) {
                int next = waiting.peekFirst();
                if (sum + next <= weight) { 
                    waiting.pollFirst();
                    bridge.addLast(next);
                    sum += next;
                } else {
                    bridge.addLast(0);
                }
            } else {
                bridge.addLast(0);
            }
        }

        return answer;
    }
}

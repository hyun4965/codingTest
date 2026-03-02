import java.util.*;

class Solution {
    public int[] solution(int[] numbers, String direction) {
        
        Deque<Integer> deque = new ArrayDeque<>();
        
        for (int num : numbers) {
            deque.addLast(num);
        }
        
        if (direction.equals("right")) {
            int last = deque.removeLast();
            deque.addFirst(last);
        } else { 
            int first = deque.removeFirst();
            deque.addLast(first);
        }
        
        int[] answer = new int[numbers.length];
        int idx = 0;
        for (int num : deque) {
            answer[idx++] = num;
        }
        
        return answer;
    }
}
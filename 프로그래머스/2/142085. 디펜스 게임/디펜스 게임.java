import java.util.*;

class Solution {
    public int solution(int n, int k, int[] enemy) {
        if (k >= enemy.length) {
            return enemy.length;
        }

        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
        int roundIndex = 0;

        for (int round : enemy) {
            n -= round;
            pq.add(round);

            if (n < 0) {
                if (k <= 0) {
                    return roundIndex;
                }
                
                k--;
                n += pq.poll();
            }
            
            roundIndex++;
        }

        return enemy.length;
    }
}
import java.util.*;

class Solution {
    public int solution(int[] queue1, int[] queue2) {
        Deque<Integer> q1 = new ArrayDeque<>();
        Deque<Integer> q2 = new ArrayDeque<>();

        long sum1 = 0;
        long sum2 = 0;

        for (int val : queue1) {
            q1.add(val);
            sum1 += val;
        }
        for (int val : queue2) {
            q2.add(val);
            sum2 += val;
        }

        long totalSum = sum1 + sum2;

        if (totalSum % 2 != 0) {
            return -1;
        }

        long target = totalSum / 2;

        int count = 0;
        int limit = (queue1.length + queue2.length) * 2;

        while (sum1 != target) {
            if (count > limit) {
                return -1;
            }

            if (sum1 > target) {
                int value = q1.poll();
                q2.add(value);
                sum1 -= value;
                sum2 += value;
            } else { 
                int value = q2.poll();
                q1.add(value);
                sum1 += value;
                sum2 -= value;
            }
            count++;
        }

        return count;
    }
}
import java.util.*;

class Solution {
    public int solution(int[] food_times, long k) {
        long total = 0;
        for (int time : food_times) {
            total += time;
        }
        if (total <= k) {
            return -1;
        }

        PriorityQueue<Food> pq = new PriorityQueue<>(
            Comparator.comparingLong(f -> f.time)
        );

        for (int i = 0; i < food_times.length; i++) {
            pq.offer(new Food(i + 1, food_times[i]));
        }

        long sumTime = 0;
        long prev = 0; 
        long remain = food_times.length; 

        while (true) {
            long now = pq.peek().time;
            long cycle = (now - prev) * remain; 

            if (sumTime + cycle > k) break; 

            sumTime += cycle;
            pq.poll(); 
            remain--;
            prev = now;
        }

        List<Food> remains = new ArrayList<>(pq);
        remains.sort(Comparator.comparingInt(f -> f.index));

        long remainTime = k - sumTime;
        int nextIndex = (int)(remainTime % remain);

        return remains.get(nextIndex).index;
    }

    static class Food {
        int index;
        long time; 

        Food(int index, long time) {
            this.index = index;
            this.time = time;
        }
    }
}

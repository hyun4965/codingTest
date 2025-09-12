import java.util.*;

class Solution {
    public int solution(String[][] book_time) {
        int answer = 0;
        int n = book_time.length;
        
        int[][] times = new int[n][2];
        
        for (int i = 0; i < n; i++) {
            int start = toMinutes(book_time[i][0]);
            int end = toMinutes(book_time[i][1]) + 10; 
            times[i][0] = start;
            times[i][1] = end;
        }

        Arrays.sort(times, (a, b) -> {
            if (a[0] != b[0]) {
                return a[0] - b[0];
            }
            return a[1] - b[1];
        });

        PriorityQueue<Integer> pq = new PriorityQueue<>();


        for (int i = 0; i < n; i++) {
            int start = times[i][0];
            int end = times[i][1];

            if (!pq.isEmpty() && pq.peek() <= start) {
                pq.poll(); 
            }

            pq.offer(end);

            answer = Math.max(answer, pq.size());
        }

        return answer;
    }

    private int toMinutes(String hhmm) {
        String[] parts = hhmm.split(":");
        int h = Integer.parseInt(parts[0]);
        int m = Integer.parseInt(parts[1]);
        return h * 60 + m;
    }
}

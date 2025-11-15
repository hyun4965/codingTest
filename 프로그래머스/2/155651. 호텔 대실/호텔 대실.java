import java.util.*;

class Solution {
    public int solution(String[][] book_time) {
        int n = book_time.length;
        int[][] times = new int[n][2]; 

        for(int i=0; i<n; i++){
            String[] start = book_time[i][0].split(":");
            String[] end = book_time[i][1].split(":");
            
            times[i][0] =  Integer.parseInt(start[0]) * 60 + Integer.parseInt(start[1]);
            times[i][1] = Integer.parseInt(end[0]) * 60 + Integer.parseInt(end[1]) + 10;
            
        }
        Arrays.sort(times, (o1, o2) -> o1[0] - o2[0]);
        
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        
        for(int i=0; i<n; i++){
            int start = times[i][0];
            int end = times[i][1];
            if (!pq.isEmpty() && pq.peek() <= start) {
                pq.poll(); 
            }
            pq.offer(end);
        }
        return pq.size();
    }
}
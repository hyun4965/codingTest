import java.util.Arrays;
import java.util.PriorityQueue;

class Solution {
    public int solution(int[][] jobs) {
        Arrays.sort(jobs, (a, b) -> a[0] - b[0]);

        PriorityQueue<int[]> waitQueue = new PriorityQueue<>((a, b) -> a[1] - b[1]);

        int jobIndex = 0;         // 처리할 jobs 배열의 인덱스
        int completedJobs = 0;    // 완료된 작업 수
        long currentTime = 0;     // 현재 시간
        long totalTurnaroundTime = 0; // 모든 작업의 총 반환 시간
        int totalJobs = jobs.length;

        while (completedJobs < totalJobs) {
            while (jobIndex < totalJobs && jobs[jobIndex][0] <= currentTime) {
                waitQueue.offer(jobs[jobIndex]);
                jobIndex++;
            }

            if (!waitQueue.isEmpty()) {
                int[] currentJob = waitQueue.poll();
                int requestTime = currentJob[0];
                int duration = currentJob[1];

                currentTime += duration;
                totalTurnaroundTime += (currentTime - requestTime);
                completedJobs++;
            } else {
                currentTime = jobs[jobIndex][0];
            }
        }

        return (int) (totalTurnaroundTime / totalJobs);
    }
}
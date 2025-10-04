import java.util.*;

class Solution {

    public int solution(int[] schedules, int[][] timelogs, int startday) {
        
        int answer = 0;
        int numPeople = schedules.length;

        for (int i = 0; i < numPeople; i++) {
            
            int deadline = calc(schedules[i]);
            int[] employeeLogs = timelogs[i];
            boolean wasEverLate = false;

            for (int day = 0; day < 7; day++) {
                int currentDayOfWeek = ((startday - 1) + day) % 7 + 1;

                if (currentDayOfWeek == 6 || currentDayOfWeek == 7) {
                    continue;
                }

                int loggedTime = employeeLogs[day];
                if (loggedTime > deadline) {
                    wasEverLate = true;
                    break;
                }
            }

            if (!wasEverLate) {
                answer++;
            }
        }

        return answer;
    }
    
    private int calc(int scheduleTime) {
        int hour = scheduleTime / 100;
        int minute = scheduleTime % 100;

        minute += 10;

        if (minute >= 60) {
            hour += 1;
            minute -= 60;
        }

        return hour * 100 + minute;
    }
}
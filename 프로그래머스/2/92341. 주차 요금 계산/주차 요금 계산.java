import java.util.*;
class Solution {
    public int[] solution(int[] fees, String[] records) {
        
        int basicTime = fees[0];
        int basicFee = fees[1];
        int unitTime = fees[2];
        int unitFee = fees[3];

        Map<String, Integer> totalTimeMap = new HashMap<>();
        Map<String, Integer> inTimeMap = new HashMap<>();

        for (String record : records) {
            String[] parts = record.split(" ");
            String timeStr = parts[0];
            String carNum = parts[1];
            String action = parts[2];

            int time = timeToMinutes(timeStr);

            if (action.equals("IN")) {
                inTimeMap.put(carNum, time);
            } else {
                int inTime = inTimeMap.remove(carNum);
                int parkedTime = time - inTime;
                totalTimeMap.put(carNum, totalTimeMap.getOrDefault(carNum, 0) + parkedTime);
            }
        }

        for (String carNum : inTimeMap.keySet()) {
            int inTime = inTimeMap.get(carNum);
            int parkedTime = timeToMinutes("23:59") - inTime;
            totalTimeMap.put(carNum, totalTimeMap.getOrDefault(carNum, 0) + parkedTime);
        }

        List<String> carNums = new ArrayList<>(totalTimeMap.keySet());
        Collections.sort(carNums);

        int[] answer = new int[carNums.size()];
        for (int i = 0; i < carNums.size(); i++) {
            int time = totalTimeMap.get(carNums.get(i));
            int fee = 0;
            if (time <= basicTime) {
                fee = basicFee;
            } else {
                fee = basicFee + (int)Math.ceil((time - basicTime) / (double)unitTime) * unitFee;
            }
            answer[i] = fee;
        }

        return answer;
    }

    private int timeToMinutes(String timeStr) {
        String[] parts = timeStr.split(":");
        int hour = Integer.parseInt(parts[0]);
        int min = Integer.parseInt(parts[1]);
        return hour * 60 + min;
    }
}

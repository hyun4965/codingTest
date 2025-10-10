class Solution {
    //play_time : 동영상 재생 길이
    //adv_time : 공익광고 재생길이
    //log : 구간정보
    public String solution(String play_time, String adv_time, String[] logs) {
        
        int playTime = timeStringToInt(play_time);
        int advTime = timeStringToInt(adv_time);
        int[] times = new int[360000];
        
        for (String log : logs) {
            String[] splitLog = log.split("-");
            int startTime = timeStringToInt(splitLog[0]);
            int endTime = timeStringToInt(splitLog[1]);
            for (int i = startTime; i < endTime; i++) {
                times[i]++;
            }
        }
        
        int maxIndex = 0;
        long totalTime = 0;
        
        for (int i = 0; i < advTime; i++) {
            totalTime += times[i];
        }
        
        long maxTotalTime = totalTime;
        for (int i = advTime; i < playTime; i++) {
            totalTime += times[i] - times[i - advTime];
            if (totalTime > maxTotalTime) {
                maxTotalTime = totalTime;
                maxIndex = i - advTime + 1;
            }
        }
        return toStrTime(maxIndex);

    }
    
    static int timeStringToInt(String strTime) {
        String[] HMS = strTime.split(":");

        int hours = Integer.parseInt(HMS[0]);
        int minutes = Integer.parseInt(HMS[1]);
        int seconds = Integer.parseInt(HMS[2]);

        return 3600 * hours + 60 * minutes + seconds;
    
    }
    String toStrTime(int time) {
        int H = time / 3600;
        int M = (time - 3600 * H) / 60;
        int S = time - 3600 * H - 60 * M;

        return (H < 10 ? "0" : "") + H + ":" +
            (M < 10 ? "0" : "") + M + ":" +
            (S < 10 ? "0" : "") + S;
    }
}
class Solution {
    public int solution(int[] schedules, int[][] timelogs, int startday) {
        int answer = timelogs.length;
        
        for(int i=0; i<schedules.length; i++){
            int h = schedules[i]/100;
            int min = schedules[i]%100;
            schedules[i] = h*60 + min + 10; 
        }
        
        for(int i=0; i<timelogs.length; i++){
            for(int j=0; j<timelogs[i].length; j++){ 
                
                int currentDay = (startday + j) % 7;
                if(currentDay == 6 || currentDay == 0){
                    continue;
                }
                
                int hour = timelogs[i][j] / 100;
                int min = timelogs[i][j] % 100;
                int arrived = hour * 60 + min;
                
                if(arrived > schedules[i]){
                    answer--;
                    break;
                }
            }
        }
        
        return answer;
    }
}
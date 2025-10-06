import java.util.*;

class Solution {
    //운행 횟수: n 회
    //운행 간격: t 분
    //최대크루수: m 명
    //크루가 대기열에 도착하는 시각: timetable[]
    public String solution(int n, int t, int m, String[] timetable) {
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        
        //문자 -> 숫자로 변환 숫자로 변환
        for (String timeStr : timetable) {
            int time = Integer.parseInt(timeStr.substring(0, 2)) * 60 + Integer.parseInt(timeStr.substring(3));
            pq.add(time);
        }
        
        int shuttleTime = 9*60; //첫 셔틀 시간 9시 
        int konTime = 0; //kon 도착시간
        
        for(int i=0; i<n; i++){
            int peopleCount =0;
            int lastPeopleTime=0;
            
            while (!pq.isEmpty() && peopleCount < m){
                int firstTime = pq.peek();  //que의 맨앞
                
                if(firstTime <= shuttleTime){ //셔틀시간보다 빠르면 태움
                    lastPeopleTime = pq.poll();
                    peopleCount++;
                }else{// 셔틀시간보다 늦으면 다음 셔틀
                    break;
                }
            }
            //마지막 셔틀일 때, 콘 부름
            if(i == n-1){
                if(peopleCount < m){
                    konTime = shuttleTime;
                }else{
                    konTime = lastPeopleTime - 1;
                }
            }
            shuttleTime +=t;
        }
        String hour = String.format("%02d", konTime / 60);
        String minute = String.format("%02d", konTime % 60);
        return hour + ":" + minute;
    }
}
import java.util.*;

class Solution {
    public int[] solution(String today, String[] terms, String[] privacies) {
        List<Integer> list = new ArrayList<>();

        String[] day = today.split("\\."); 
        int todayNum = Integer.parseInt(day[0]) * 12 * 28
                     + Integer.parseInt(day[1]) * 28
                     + Integer.parseInt(day[2]);

        Map<Character, Integer> termMap = new HashMap<>();
        for (String t : terms) {  
            String[] sp = t.split(" ");    
            char type = sp[0].charAt(0);
            int months = Integer.parseInt(sp[1]); 
            termMap.put(type, months);
        }

        for (int i = 0; i < privacies.length; i++) {
            String p = privacies[i];
            String[] sp = p.split(" ");

            String dateStr = sp[0]; 
            char type = sp[1].charAt(0); 

            String[] collect = dateStr.split("\\.");
            int collectNum = Integer.parseInt(collect[0]) * 12 * 28
                           + Integer.parseInt(collect[1]) * 28
                           + Integer.parseInt(collect[2]);

            int months = termMap.get(type);

            int expireNum = collectNum + months * 28 - 1;

            if (todayNum > expireNum) {
                list.add(i + 1); 
            }
        }

        int[] answer = new int[list.size()];
        for (int i = 0; i < list.size(); i++) {
            answer[i] = list.get(i);
        }

        return answer;
    }
}

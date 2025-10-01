import java.util.*;

class Solution {
    public int[] solution(String today, String[] terms, String[] privacies) {
        List<Integer> expiredList = new ArrayList<>();
        
        Map<String, Integer> termsMap = new HashMap<>();
        for (String term : terms) {
            String[] parts = term.split(" ");
            termsMap.put(parts[0], Integer.parseInt(parts[1]));
        }
        
        int todayInDays = dateToDays(today);
        
        for (int i = 0; i < privacies.length; i++) {
            String[] privacyParts = privacies[i].split(" ");
            String collectionDateStr = privacyParts[0];
            String termType = privacyParts[1];
            
            int collectionDateInDays = dateToDays(collectionDateStr);
            
            int durationInMonths = termsMap.get(termType);
            
            int expirationDateInDays = collectionDateInDays + (durationInMonths * 28);
            
            if (todayInDays >= expirationDateInDays) {
                expiredList.add(i + 1); 
            }
        }
        
        int[] answer = new int[expiredList.size()];

        for (int i = 0; i < expiredList.size(); i++) {
            answer[i] = expiredList.get(i); 
        }

        return answer;    
    }
    
    private int dateToDays(String date) {
        String[] ymd = date.split("\\."); 
        int year = Integer.parseInt(ymd[0]);
        int month = Integer.parseInt(ymd[1]);
        int day = Integer.parseInt(ymd[2]);
        
        return (year * 12 * 28) + (month * 28) + day;
    }
}
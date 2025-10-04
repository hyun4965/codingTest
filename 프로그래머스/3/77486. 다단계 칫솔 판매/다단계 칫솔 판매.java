import java.util.HashMap;
import java.util.Map;

class Solution {
    public int[] solution(String[] enroll, String[] referral, String[] seller, int[] amount) {
        Map<String, String> parentMap = new HashMap<>();
        Map<String, Integer> profitMap = new HashMap<>();

        for (int i = 0; i < enroll.length; i++) {
            parentMap.put(enroll[i], referral[i]);
            profitMap.put(enroll[i], 0);
        }

        for (int i = 0; i < seller.length; i++) {
            String currentPerson = seller[i];
            int profit = amount[i] * 100;

            while (profit > 0 && !currentPerson.equals("-")) {
                int commission = profit / 10;
                int myTake = profit - commission;

                profitMap.put(currentPerson, profitMap.get(currentPerson) + myTake);
                
                currentPerson = parentMap.get(currentPerson);
                profit = commission;
            }
        }

        int[] answer = new int[enroll.length];
        for (int i = 0; i < enroll.length; i++) {
            answer[i] = profitMap.get(enroll[i]);
        }

        return answer;
    }
}
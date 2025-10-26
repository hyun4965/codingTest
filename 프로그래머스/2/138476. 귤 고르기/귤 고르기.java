import java.util.*;

class Solution {
    public int solution(int k, int[] tangerine) {
        int answer = 0;

        Map<Integer, Integer> counts = new HashMap<>();
        for (int size : tangerine) {
            counts.put(size, counts.getOrDefault(size, 0) + 1);
        }

        List<Integer> countList = new ArrayList<>(counts.values());

        Collections.sort(countList, Collections.reverseOrder());

        int taken = 0; 
        for (int count : countList) {
            if (taken >= k) { 
                break;
            }
            taken += count; 
            answer++; 
        }

        return answer;
    }
}
import java.util.*;

class Solution {
    public int[] solution(String[] gems) {
        int[] answer = new int[2];

        Set<String> set = new HashSet<>();
        for (int i = 0; i < gems.length; i++) {
            set.add(gems[i]);
        }
        int needKinds = set.size();

        Map<String, Integer> freq = new HashMap<>();
        int left = 0;                    
        int bestL = 0;
        int bestR = gems.length - 1;
        int bestLen = bestR - bestL; 

        for (int right = 0; right < gems.length; right++) {
            freq.put(gems[right], freq.getOrDefault(gems[right], 0) + 1);

            while (freq.size() == needKinds) {
                int currLen = right - left;
                if (currLen < bestLen || (currLen == bestLen && left < bestL)) {
                    bestLen = currLen;
                    bestL = left;
                    bestR = right;
                }

                String gl = gems[left];
                int cnt = freq.get(gl) - 1;
                
                if (cnt == 0) {
                    freq.remove(gl);
                }else {
                    freq.put(gl, cnt);
                }

                left++;
            }
        }

        answer[0] = bestL + 1;
        answer[1] = bestR + 1;
        return answer;
    }
}

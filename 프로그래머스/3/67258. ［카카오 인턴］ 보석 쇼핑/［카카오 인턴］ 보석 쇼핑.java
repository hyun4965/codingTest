import java.util.*;

class Solution {
    public int[] solution(String[] gems) {
        int len = gems.length;

        Set<String> set = new HashSet<>();
        for (String g : gems) {
            set.add(g);
        }
        int kind = set.size();  

        Map<String, Integer> map = new HashMap<>();
        int left = 0, right = 0;
        int bestL = 0, bestR = len - 1;
        int minLen = Integer.MAX_VALUE;

        while (true) {
            if (map.size() < kind) {
                if (right == len) {
                    break;  
                }
                map.put(gems[right], map.getOrDefault(gems[right], 0) + 1);
                right++;
            } else {
                if (right - left < minLen) {
                    minLen = right - left;
                    bestL = left;
                    bestR = right - 1; 
                }

                String leftGem = gems[left];
                int cnt = map.get(leftGem);
                if (cnt == 1) {
                    map.remove(leftGem);
                } else {
                    map.put(leftGem, cnt - 1);
                }
                left++;
            }
        }

        return new int[]{bestL + 1, bestR + 1};
    }
}

import java.util.HashMap;

class Solution {
    public int solution(String[] strArr) {
        HashMap<Integer, Integer> lengthCount = new HashMap<>();

        for (String str : strArr) {
            int len = str.length();
            lengthCount.put(len, lengthCount.getOrDefault(len, 0) + 1);
        }

        int max = 0;
        for (int count : lengthCount.values()) {
            max = Math.max(max, count);
        }

        return max;
    }
}

import java.util.*;

class Solution {
    public String[] solution(String[] orders, int[] course) {
        List<String> result = new ArrayList<>();

        for (int k : course) {
            Map<String, Integer> freq = new HashMap<>();

            for (String order : orders) {
                if (order.length() < k) continue;
                char[] arr = order.toCharArray();
                Arrays.sort(arr);
                dfs(arr, 0, 0, k, new StringBuilder(), freq);
            }

            int max = 0;
            for (int v : freq.values()) {
                if (v > max) max = v;
            }

            if (max >= 2) {
                for (Map.Entry<String, Integer> e : freq.entrySet()) {
                    if (e.getValue() == max) {
                        result.add(e.getKey());
                    }
                }
            }
        }

        Collections.sort(result);
        return result.toArray(new String[0]);
    }
    private void dfs(char[] arr, int idx, int picked, int target, StringBuilder sb, Map<String, Integer> freq) {
        if (picked == target) {
            freq.merge(sb.toString(), 1, Integer::sum);
            return;
        }
        for (int i = idx; i < arr.length; i++) {
            sb.append(arr[i]);
            dfs(arr, i + 1, picked + 1, target, sb, freq);
            sb.deleteCharAt(sb.length() - 1);
        }
    }
}

import java.util.*;

class Solution {
    public int[] solution(String[] info, String[] query) {
        
        Map<String, List<Integer>> index = new HashMap<>();

        for (String s : info) {
            String[] sp = s.split(" ");
            String[] attrs = { sp[0], sp[1], sp[2], sp[3] };
            int score = Integer.parseInt(sp[4]);

            for (int mask = 0; mask < (1 << 4); mask++) {
                StringBuilder key = new StringBuilder();
                for (int i = 0; i < 4; i++) {
                    if ((mask & (1 << i)) != 0) {
                        key.append("-");
                    } else {
                        key.append(attrs[i]);
                    }
                    if (i < 3) {
                        key.append("_");
                    }
                }
                index.computeIfAbsent(key.toString(), k -> new ArrayList<>()).add(score);
            }
        }

        for (List<Integer> list : index.values()) {
            Collections.sort(list);
        }

        int[] answer = new int[query.length];
        for (int qi = 0; qi < query.length; qi++) {
            String q = query[qi].replace(" and ", " ");
            String[] sp = q.split(" ");
            String key = sp[0] + "_" + sp[1] + "_" + sp[2] + "_" + sp[3];
            int target = Integer.parseInt(sp[4]);

            List<Integer> list = index.getOrDefault(key, Collections.emptyList());
            int cnt = list.size() - lowerBound(list, target);
            answer[qi] = cnt;
        }

        return answer;
    }

    private int lowerBound(List<Integer> list, int value) {
        int lo = 0, hi = list.size();
        while (lo < hi) {
            int mid = (lo + hi) >>> 1;
            if (list.get(mid) >= value) hi = mid;
            else lo = mid + 1;
        }
        return lo;
    }
}

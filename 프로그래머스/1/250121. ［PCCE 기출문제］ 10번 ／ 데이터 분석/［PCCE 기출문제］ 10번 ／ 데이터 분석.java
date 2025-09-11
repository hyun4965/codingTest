import java.util.*;

class Solution {
    public int[][] solution(int[][] data, String ext, int val_ext, String sort_by) {
        int filterIdx = idx(ext);
        int sortIdx   = idx(sort_by);

        List<int[]> picked = new ArrayList<>();
        for (int[] row : data) {
            if (row[filterIdx] < val_ext) picked.add(row);
        }

        picked.sort(Comparator.comparingInt(a -> a[sortIdx]));

        int[][] answer = new int[picked.size()][];
        for (int i = 0; i < picked.size(); i++) {
            answer[i] = picked.get(i);
        }
        return answer;
    }

    private int idx(String key) {
        switch (key) {
            case "code":    return 0;
            case "date":    return 1;
            case "maximum": return 2;
            case "remain":  return 3;
        }
        throw new IllegalArgumentException("Unknown key: " + key);
    }
}

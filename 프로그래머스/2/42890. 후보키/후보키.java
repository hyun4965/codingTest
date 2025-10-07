import java.util.*;

class Solution {
    public int solution(String[][] relation) {
        int n = relation.length;
        int m = relation[0].length;

        List<Set<Integer>> candidateKeys = new ArrayList<>();

        for (int size = 1; size <= m; size++) {
            dfs(0, size, new ArrayList<>(), relation, candidateKeys);
        }
        return candidateKeys.size();
    }

    private void dfs(int start, int targetSize, List<Integer> pick,
                     String[][] relation, List<Set<Integer>> candidateKeys) {

        if (pick.size() == targetSize) {
            Set<Integer> curSet = new HashSet<>(pick);
            for (Set<Integer> key : candidateKeys) {
                if (curSet.containsAll(key)) return; 
            }

            if (isUnique(pick, relation)) {
                candidateKeys.add(curSet); 
            }
            return;
        }

        int m = relation[0].length;
        for (int col = start; col < m; col++) {
            pick.add(col);
            dfs(col + 1, targetSize, pick, relation, candidateKeys);
            pick.remove(pick.size() - 1);
        }
    }

    private boolean isUnique(List<Integer> cols, String[][] relation) {
        Set<String> seen = new HashSet<>();
        for (String[] row : relation) {
            StringBuilder sb = new StringBuilder();
            for (int c : cols) { 
                sb.append(row[c]).append('\u0001');
            }
            if (!seen.add(sb.toString())) return false; 
        }
        return true;
    }
}

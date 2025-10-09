import java.util.*;

class Solution {
    private int maxSheep = 0;
    private int[] info;
    private List<List<Integer>> tree;

    public int solution(int[] info, int[][] edges) {
        
        this.info = info;
        this.tree = new ArrayList<>();

        for (int i = 0; i < info.length; i++) {
            tree.add(new ArrayList<>());
        }
        for (int[] edge : edges) {
            tree.get(edge[0]).add(edge[1]);
        }

        List<Integer> initialNextNodes = new ArrayList<>();
        if (!tree.get(0).isEmpty()) {
            initialNextNodes.addAll(tree.get(0));
        }

        dfs(1, 0, initialNextNodes);

        return maxSheep;
    }

    private void dfs(int sheepCount, int wolfCount, List<Integer> possibleNodes) {
        maxSheep = Math.max(maxSheep, sheepCount);

        for (int nextNode : possibleNodes) {
            int newSheepCount = sheepCount;
            int newWolfCount = wolfCount;

            if (info[nextNode] == 0) {
                newSheepCount++;
            } else {
                newWolfCount++;
            }

            if (newSheepCount > newWolfCount) {
                List<Integer> nextPossibleNodes = new ArrayList<>(possibleNodes);
                nextPossibleNodes.remove(Integer.valueOf(nextNode));
                if (!tree.get(nextNode).isEmpty()) {
                    nextPossibleNodes.addAll(tree.get(nextNode));
                }
                
                dfs(newSheepCount, newWolfCount, nextPossibleNodes);
            }
        }
    }
}
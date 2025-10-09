import java.util.*;

class Solution {
    public int solution(int[] cards) {
        int len = cards.length;
        boolean[] visited = new boolean[len];
        List<Integer> sizes = new ArrayList<>();

        for (int i = 0; i < len; i++) {
            if (visited[i]) {
                continue;
            }
            int count = 0;
            int current = i;
            while (!visited[current]) {
                visited[current] = true;
                current = cards[current] - 1; 
                count++;
            }
            sizes.add(count);
        }

        sizes.sort(Collections.reverseOrder());
        return sizes.size() < 2 ? 0 : sizes.get(0) * sizes.get(1);
    }
}

import java.util.ArrayList;
import java.util.List;

class Solution {
    List<int[]> moveList;

    public int[][] solution(int n) {
        moveList = new ArrayList<>();
        
        hanoi(n, 1, 2, 3);
        
        int[][] answer = new int[moveList.size()][2];
        for (int i = 0; i < moveList.size(); i++) {
            answer[i] = moveList.get(i);
        }
        
        return answer;
    }

    private void hanoi(int n, int start, int via, int end) {
        if (n == 1) {
            moveList.add(new int[]{start, end});
            return;
        }
        
        hanoi(n - 1, start, end, via);
        
        moveList.add(new int[]{start, end});
        
        hanoi(n - 1, via, start, end);
    }
}
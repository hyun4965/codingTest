import java.util.ArrayList;
import java.util.List;

class Solution {
    private List<int[]> sequence;

    public int[][] solution(int n) {
        sequence = new ArrayList<>();
        
        hanoi(n, 1, 3, 2);
        
        int[][] answer = new int[sequence.size()][2];
        for(int i = 0; i < sequence.size(); i++){
            answer[i] = sequence.get(i);
        }
        
        return answer;
    }

    private void hanoi(int n, int start, int end, int via){
        if(n == 1){
            sequence.add(new int[]{start, end});
            return;
        }

        hanoi(n - 1, start, via, end);

        sequence.add(new int[]{start, end});

        hanoi(n - 1, via, end, start);
    }
}
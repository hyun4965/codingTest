import java.util.*;

class Solution {
    public int solution(int[][] data, int col, int row_begin, int row_end) {
        int answer = 0;
        final int colnum = col - 1;
        Arrays.sort(data, (a, b) -> {
            if (a[colnum] != b[colnum]) {
                return a[colnum] - b[colnum];
            }
            return b[0] - a[0];
        });

        for(int i=row_begin-1; i<= row_end-1; i++){
            int s = 0;
            int rowNum = i+1;
            for(int j=0; j<data[i].length; j++){
                s += data[i][j] % rowNum;
            }
            answer ^=s;
            
        }
        
        
        return answer;
    }
}
class Solution {

    static int[] answer = new int[2];
    
    public int[] solution(int[][] arr) {
        
        comp(arr, 0, 0, arr.length);
        
        return answer;
    }
    
    private static void comp(int[][] arr, int x, int y, int length) {
        int s = arr[x][y];
        boolean canComp = true;
		
        if(length == 1) {
            if(s == 0) answer[0]++;
            else answer[1]++;

            return;
        }

        check:
        for(int i = x; i < x + length; i++) {
            for(int j = y; j < y + length; j++){
                if(arr[i][j] != s) {
                    canComp = false;
                    break check;
                }
            }
        }

        if(canComp) { 
            if(s == 0) answer[0]++;
            else answer[1]++;
        } else { 
            for(int i = x; i < x + length; i += length / 2) {
                for(int j = y; j < y + length; j += length / 2) {
                    comp(arr, i, j, length / 2);
                }
            }
        }
    }
}
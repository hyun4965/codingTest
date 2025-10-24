import java.util.*;

class Solution {
    public int[] solution(int[] array, int[][] commands) {
        int[] answer = new int[commands.length];
        int time = 0;
        for(int[] command :commands ){
            int start = command[0];
            int end = command[1];
            int pick = command[2];
            int[] newArr = new int[end-start+1];
            int index =0;
            for (int i = start - 1; i <= end - 1; i++) {
                newArr[index++] = array[i];
            }
            Arrays.sort(newArr);
            answer[time++] = newArr[pick-1];
        }
        
        return answer;
    }
}
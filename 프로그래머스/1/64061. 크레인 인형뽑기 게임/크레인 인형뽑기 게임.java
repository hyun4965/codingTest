import java.util.*;
class Solution {
    public int solution(int[][] board, int[] moves) {
        int answer = 0;
        
        Stack<Integer> stack = new Stack<>();
        
        for(int i=0; i<moves.length; i++){
            int num = moves[i];
            int col = num - 1;  
            for(int j=0; j<board.length; j++){
                if(board[j][col] == 0){
                    continue;
                }else{
                    int pick = board[j][col];
                    if( !stack.isEmpty() && pick == stack.peek()){
                        stack.pop();
                        answer +=2;
                    }else{
                        stack.push(pick);
                    }
                    board[j][col] = 0;
                    break;
                }
            }
            
        }
        
        return answer;
    }
}
import java.util.Stack;
import java.util.Deque;
import java.util.ArrayDeque;

class Solution {
    public int solution(int[][] board, int[] moves) {
        int answer = 0;

        Stack<Integer> stack = new Stack<>(); 
        Deque<Integer> que = new ArrayDeque<>(); 

        for (int m : moves) {
            que.addLast(m);
        }
        while (!que.isEmpty()) {
            int num = que.pollFirst(); 
            int col = num - 1; 

            for (int row = 0; row < board.length; row++) {
                if (board[row][col] != 0) {
                    int doll = board[row][col];
                    board[row][col] = 0;

                    if (!stack.isEmpty() && stack.peek() == doll) {
                        stack.pop();
                        answer += 2;
                    } else {
                        stack.push(doll);
                    }
                    break; 
                }
            }
        }

        return answer;
    }
}

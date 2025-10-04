import java.util.HashMap;
import java.util.Map;

class Solution {
    public int[] solution(String[] park, String[] routes) {
        int H = park.length;
        int W = park[0].length();

        int currentRow = -1;
        int currentCol = -1;
        for (int i = 0; i < H; i++) {
            for (int j = 0; j < W; j++) {
                if (park[i].charAt(j) == 'S') {
                    currentRow = i;
                    currentCol = j;
                    break; 
                }
            }
            if (currentRow != -1) {
                break;
            }
        }

        Map<Character, int[]> directions = new HashMap<>();
        directions.put('N', new int[]{-1, 0});
        directions.put('S', new int[]{1, 0});  
        directions.put('W', new int[]{0, -1}); 
        directions.put('E', new int[]{0, 1});  

        for (String route : routes) {
            String[] command = route.split(" ");
            char op = command[0].charAt(0);      // 방향
            int n = Integer.parseInt(command[1]); // 거리

            int[] move = directions.get(op);
            int dr = move[0];
            int dc = move[1];

            boolean isMoveValid = true;
            int nextRow = currentRow;
            int nextCol = currentCol;

            for (int i = 0; i < n; i++) {
                nextRow += dr;
                nextCol += dc;

                if (nextRow < 0 || nextRow >= H || nextCol < 0 || nextCol >= W) {
                    isMoveValid = false;
                    break;
                }
                if (park[nextRow].charAt(nextCol) == 'X') {
                    isMoveValid = false;
                    break;
                }
            }

            if (isMoveValid) {
                currentRow = nextRow;
                currentCol = nextCol;
            }
        }

        return new int[]{currentRow, currentCol};
    }
}
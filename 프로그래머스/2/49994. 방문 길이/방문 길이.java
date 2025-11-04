import java.util.HashSet;

class Solution {
    public int solution(String dirs) {
        int answer = 0;
        
        int x = 5;
        int y = 5;

        HashSet<String> visitedPaths = new HashSet<>();
        
        for (char cmd : dirs.toCharArray()) {
            
            int startX = x;
            int startY = y;
            
            int nextX = x;
            int nextY = y;

            if (cmd == 'U') {
                nextY++;
            } else if (cmd == 'D') {
                nextY--;
            } else if (cmd == 'R') {
                nextX++;
            } else if (cmd == 'L') {
                nextX--;
            }
            
            if (nextX < 0 || nextX > 10 || nextY < 0 || nextY > 10) {
                continue; 
            }
            
            String path = startX + "," + startY + "," + nextX + "," + nextY;
            String reversePath = nextX + "," + nextY + "," + startX + "," + startY;
            
            if (!visitedPaths.contains(path) && !visitedPaths.contains(reversePath)) {
                answer++;
                visitedPaths.add(path);
            }
            
            x = nextX;
            y = nextY;
        }
        
        return answer;
    }
}
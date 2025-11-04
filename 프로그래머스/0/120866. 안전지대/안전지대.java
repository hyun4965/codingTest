class Solution {
    int[] dx = {-1, -1, -1,  0, 0, 0,  1, 1, 1};
    int[] dy = {-1,  0,  1, -1, 0, 1, -1, 0, 1};
    public int solution(int[][] board) {
        int answer = 0;
        int n = board.length; 

        int[][] danger = new int[n][n];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                
                if (board[i][j] == 1) {
                    
                    for (int k = 0; k < 9; k++) {
                        int nx = i + dx[k]; 
                        int ny = j + dy[k]; 
                        
                        if (nx >= 0 && nx < n && ny >= 0 && ny < n) {
                            danger[nx][ny] = 1; 
                        }
                    }
                }
            }
        }
        
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (danger[i][j] == 0) {
                    answer++;
                }
            }
        }
        
        return answer;
    }
}
class Solution {
    public int[][] solution(int n) {
        int[][] answer = new int[n][n];

        int[] dr = {0, 1, 0, -1};
        int[] dc = {1, 0, -1, 0};

        int row = 0;
        int col = 0;
        int direction = 0; // 0: 오른쪽, 1: 아래, 2: 왼쪽, 3: 위

        for (int num = 1; num <= n * n; num++) {
            answer[row][col] = num;

            int nextRow = row + dr[direction];
            int nextCol = col + dc[direction];

            if (nextRow < 0 || nextRow >= n || nextCol < 0 || nextCol >= n || answer[nextRow][nextCol] != 0) {
                direction = (direction + 1) % 4;
            }

            row += dr[direction];
            col += dc[direction];
        }
        
        return answer;
    }
}
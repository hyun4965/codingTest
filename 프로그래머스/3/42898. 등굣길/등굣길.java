class Solution {
    final int MOD = 1_000_000_007;

    public int solution(int m, int n, int[][] puddles) {
        // 1. dp 배열 생성 (m행 n열)
        // 문제의 (m, n)은 (열, 행)이 아니라 (m행, n열)을 의미하는 것으로 보입니다.
        // 하지만 puddles가 [x, y] (열, 행)으로 주어지므로,
        // 배열을 [n][m] (n행 m열)로 만들고 (행, 열)로 접근하는 것이 덜 헷갈립니다.
        
        // m, n을 (열, 행)으로 통일
        int numCols = m;
        int numRows = n;
        
        // dp[row][col]
        long[][] dp = new long[numRows][numCols];
        
        // 2. 웅덩이 표시 (puddle = [col, row])
        for (int[] puddle : puddles) {
            int col = puddle[0] - 1; // 0-based index
            int row = puddle[1] - 1; // 0-based index
            dp[row][col] = -1; // -1로 웅덩이 표시
        }
        
        // 3. 시작점 초기화
        dp[0][0] = 1;
        
        // 4. DP 점화식 적용
        for (int i = 0; i < numRows; i++) {
            for (int j = 0; j < numCols; j++) {
                
                // 웅덩이면 0으로 만들고 건너뛰기
                if (dp[i][j] == -1) {
                    dp[i][j] = 0;
                    continue;
                }
                
                // 위에서 오는 경우 (i > 0)
                if (i > 0) {
                    dp[i][j] = (dp[i][j] + dp[i-1][j]) % MOD;
                }
                
                // 왼쪽에서 오는 경우 (j > 0)
                if (j > 0) {
                    dp[i][j] = (dp[i][j] + dp[i][j-1]) % MOD;
                }
            }
        }
        
        // 5. 최종 결과 반환
        return (int) dp[numRows - 1][numCols - 1];
    }
}
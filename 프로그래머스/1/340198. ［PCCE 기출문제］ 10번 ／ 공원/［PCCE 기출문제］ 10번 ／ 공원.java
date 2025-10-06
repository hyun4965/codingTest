import java.util.*;

class Solution {
    public int solution(int[] mats, String[][] park) {
        int maxPossible = findMax(park);

        if (maxPossible == 0) {
            return -1;
        }
        Arrays.sort(mats);
        
        for (int i = mats.length - 1; i >= 0; i--) {
            int matSize = mats[i];
            if (matSize <= maxPossible) {
                return matSize;
            }
        } 
        return -1;
    }

    private int findMax(String[][] park) {
        if (park == null || park.length == 0 || park[0].length == 0) {
            return 0;
        }

        int rows = park.length;
        int cols = park[0].length;
        int[][] dp = new int[rows + 1][cols + 1];
        int maxSide = 0;

        for (int i = 1; i <= rows; i++) {
            for (int j = 1; j <= cols; j++) {
                if (park[i - 1][j - 1].equals("-1")) {
                    dp[i][j] = 1 + Math.min(dp[i - 1][j - 1], Math.min(dp[i - 1][j], dp[i][j - 1]));
                    
                    maxSide = Math.max(maxSide, dp[i][j]);
                }
            }
        }

        return maxSide;
    }
}
import java.util.*;

class Solution {
    public int solution(int[][] scores) {
        int n = scores.length;
        int wanA = scores[0][0];
        int wanB = scores[0][1];
        int wanSum = wanA + wanB;

        Arrays.sort(scores, (x, y) -> {
            if (x[0] != y[0]) {
                return y[0] - x[0];
            }
            return x[1] - y[1];
        });

        int rank = 1;   
        int maxB = -1; 

        for (int[] s : scores) {
            int a = s[0], b = s[1];
            if (b < maxB) {
                if (a == wanA && b == wanB) {
                    return -1;
                }
                continue;
            }

            if (a + b > wanSum) {
                rank++;
            }

            if (b > maxB) {
                maxB = b;
            }
        }

        return rank;
    }
}

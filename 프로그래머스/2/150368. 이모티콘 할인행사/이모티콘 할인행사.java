import java.util.*;

class Solution {
    static final int[] R = {10, 20, 30, 40};
    int maxSub = 0;
    int maxRev = 0;

    public int[] solution(int[][] users, int[] emoticons) {
        maxSub = 0;
        maxRev = 0;

        int[] pick = new int[emoticons.length];
        dfs(0, users, emoticons, pick);
        return new int[]{maxSub, maxRev};
    }

    private void dfs(int index, int[][] users, int[] emoticons, int[] pick) {
        if (index == emoticons.length) {
            eval(users, emoticons, pick);
            return;
        }
        for (int r : R) {
            pick[index] = r;
            dfs(index + 1, users, emoticons, pick);
        }
    }

    private void eval(int[][] users, int[] emoticons, int[] pick) {
        int sub = 0;
        int rev = 0;

        for (int[] u : users) {
            int need = u[0]; 
            int limit = u[1];
            int sum = 0;

            for (int i = 0; i < emoticons.length; i++) {
                if (pick[i] >= need) {
                    int price = emoticons[i] * (100 - pick[i]) / 100;
                    sum += price;
                }
            }

            if (sum >= limit) sub++;
            else rev += sum;
        }

        if (sub > maxSub || (sub == maxSub && rev > maxRev)) {
            maxSub = sub;
            maxRev = rev;
        }
    }
}

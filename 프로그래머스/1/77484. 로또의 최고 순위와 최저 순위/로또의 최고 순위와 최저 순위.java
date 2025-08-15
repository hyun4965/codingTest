import java.util.*;

class Solution {
    public int[] solution(int[] lottos, int[] win_nums) {
        int[] answer = new int[2];
        Arrays.sort(win_nums);

        int high = 0; 
        int low = 0; 
        int zeroCount = 0;

        for (int i = 0; i < 6; i++) {
            if (lottos[i] == 0) {
                zeroCount++;
            }
        }

        for (int i = 0; i < 6; i++) {
            if (lottos[i] == 0) {
                continue; 
            }
            for (int j = 0; j < 6; j++) {
                if (lottos[i] == win_nums[j]) {
                    low++;
                    break;
                }
            }
        }

        high = low + zeroCount;

        answer[0] = getRank(high);
        answer[1] = getRank(low);

        return answer;
    }

    private int getRank(int count) {
        if (count >= 2) {
            return 7 - count;
        } else {
            return 6;
        }
    }
}

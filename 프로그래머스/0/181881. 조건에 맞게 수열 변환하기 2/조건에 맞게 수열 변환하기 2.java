import java.util.Arrays;

class Solution {
    public int solution(int[] arr) {
        int count = 0;
        int[] prev = Arrays.copyOf(arr, arr.length);
        int[] next = new int[arr.length];

        while (true) {
            for (int i = 0; i < arr.length; i++) {
                int val = prev[i];
                if (val >= 50 && val % 2 == 0) {
                    next[i] = val / 2;
                } else if (val < 50 && val % 2 == 1) {
                    next[i] = val * 2 + 1;
                } else {
                    next[i] = val;
                }
            }

            if (Arrays.equals(prev, next)) {
                break;
            }

            prev = Arrays.copyOf(next, next.length);
            count++;
        }

        return count;
    }
}

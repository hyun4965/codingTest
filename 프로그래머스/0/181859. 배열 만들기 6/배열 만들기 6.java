import java.util.Arrays;

class Solution {
    public int[] solution(int[] arr) {
        int[] stk = new int[arr.length];
        int top = 0;

        for (int num : arr) {
            if (top == 0) {
                stk[top++] = num;
            } else if (stk[top - 1] == num) {
                top--;
            } else {
                stk[top++] = num;
            }
        }

        if (top == 0) {
            return new int[]{-1};
        }

        return Arrays.copyOf(stk, top);
    }
}
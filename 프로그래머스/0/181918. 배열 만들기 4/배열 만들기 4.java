class Solution {
    public int[] solution(int[] arr) {
        int[] stk = new int[arr.length];
        int top = 0;
        int i = 0;

        while (i < arr.length) {
            if (top == 0) {
                stk[top++] = arr[i];
                i++;
            } else if (stk[top - 1] < arr[i]) {
                stk[top++] = arr[i];
                i++;
            } else {
                top--;
            }
        }

        int[] answer = new int[top];
        for (int j = 0; j < top; j++) {
            answer[j] = stk[j];
        }

        return answer;
    }
}
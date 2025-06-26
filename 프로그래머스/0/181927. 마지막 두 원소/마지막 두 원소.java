class Solution {
    public int[] solution(int[] num_list) {
        int len = num_list.length;
        int last = num_list[len - 1];
        int secondLast = num_list[len - 2];
        int n;

        if (last > secondLast) {
            n = last - secondLast;
        } else {
            n = last * 2;
        }

        int[] answer = new int[len + 1];
        for (int i = 0; i < len; i++) {
            answer[i] = num_list[i];
        }
        answer[len] = n;

        return answer;
    }
}

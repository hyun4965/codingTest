class Solution {
    public int[] solution(int start_num, int end_num) {
        int size = start_num - end_num + 1;  
        int[] answer = new int[size];

        int index = 0;
        for (int i = start_num; i >= end_num; i--) {
            answer[index++] = i;   
        }

        return answer;
    }
}

class Solution {
    public int solution(int[] arr, int idx) {
        int answer = -1;  

        for (int index = idx; index < arr.length; index++) {
            if (arr[index] == 1) {        
                answer = index;
                break;
            }
        }
        return answer;
    }
}
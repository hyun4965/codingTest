class Solution {
    public int[] solution(int[] arr, int[][] queries) {
        int[] answer = arr;
        
        for(int[] cur : queries){
            int i = cur[0];
            int j = cur[1];
            
            int temp = answer[i];
            answer[i] = answer[j];
            answer[j]= temp;
        }
        
        return answer;
    }
}
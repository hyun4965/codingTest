class Solution {
    public int[] solution(int[] array) {
        int[] answer = new int[2];
        
        int index = 0;
        int max = array[0];
        for(int i=0; i<array.length; i++){
            if(max <= array[i]){
                answer[0] = array[i];
                max = answer[0];
                answer[1] = i;
            }
        }

        return answer;
    }
}
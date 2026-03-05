class Solution {
    public int[] solution(int[] arr) {
        int len = arr.length;
        int i=1;
        while(true){
            if(len <= i){
                break;
            }
            i*=2;
        }
        
        int[] answer = new int[i];
        for(int j=0; j<arr.length; j++){
            answer[j] = arr[j];
        }
        return answer;
    }
}
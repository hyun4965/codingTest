class Solution {
    public int solution(int[] arr, int idx) {
        int answer = 0;
        for(int i=idx; i<arr.length; i++){
            if(1 == arr[i]){
                return i;
            }
        }
        return -1;
    }
}
class Solution {
    public int solution(int slice, int n) {
        int answer = 0;
        if((n%slice) !=0 ){
            answer = (n/slice) + 1 ;
        }else if((n%slice) ==0){
            answer = (n/slice);
        }
        
        return answer;
    }
}
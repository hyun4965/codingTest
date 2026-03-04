class Solution {
    public int solution(int[] numbers) {
        boolean[] isVisited = new boolean[10];
        for(int i=0; i<numbers.length; i++){
            isVisited[numbers[i]] = true;
        }
        int answer = 0;
        for(int i=0; i<isVisited.length; i++){
            if(!isVisited[i]){
                answer+=i;
            }
        }
        
        
        return answer;
    }
}
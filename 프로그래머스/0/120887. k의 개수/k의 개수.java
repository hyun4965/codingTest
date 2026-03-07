class Solution {
    public int solution(int i, int j, int k) {
        int answer = 0;
        
        for(int num = i; num <= j; num++){
            String str = String.valueOf(num);
            
            for(char c : str.toCharArray()){
                if(c == (char)(k + '0')){
                    answer++;
                }
            }
        }
        
        return answer;
    }
}
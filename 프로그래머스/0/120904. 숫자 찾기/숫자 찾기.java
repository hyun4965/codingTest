class Solution {
    public int solution(int num, int k) {
        
        String str = String.valueOf(num);
        String a = String.valueOf(k);
        char n = a.charAt(0);
        for(int i=0; i<str.length(); i++){
            char c =str.charAt(i);
            if( c == n){
                return i+1;
            }    
        }
        return -1;
    }
}
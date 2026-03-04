class Solution {
    boolean solution(String s) {
        boolean answer = true;
        String str = s.toLowerCase();

        int pCount = 0;
        int yCount = 0;
        
        for(int i=0; i<str.length(); i++){
            char c = str.charAt(i);
            if( c == 'p'){
                pCount ++;
            }else if( c == 'y'){
                yCount ++;
            }
        }
        if(pCount == yCount){
            return true;
        }else{
            return false;
        }

    }
}
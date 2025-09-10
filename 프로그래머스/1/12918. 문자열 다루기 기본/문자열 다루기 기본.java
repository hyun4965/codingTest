class Solution {
    public boolean solution(String s) {
        if(s.length() != 4 && s.length() != 6 ){
            return false;
        }
        int sum = 0;
        for(int i=0; i<s.length(); i++){
            char c = s.charAt(i);
            if(c>='0' && c<='9'){
                sum ++;
            }
        }
        if(s.length() == sum){
            return true;
        }else{
            return false;
        }
    }
}
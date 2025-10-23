import java.util.Arrays;    

class Solution {
    public int[] solution(int[] numlist, int n) {
        Arrays.sort(numlist);
        int len = numlist.length;
        for(int i=0; i<len;i++){
            for(int j=0; j<len; j++){
                if(Math.abs(numlist[i]-n)<= Math.abs(numlist[j]-n)){
                    int temp = numlist[i];
                    numlist[i] = numlist[j];
                    numlist[j] = temp;
                }
            }
        }
        
    
        
        return numlist;
    }
}
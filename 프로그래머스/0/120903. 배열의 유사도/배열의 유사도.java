import java.util.*;

class Solution {
    public int solution(String[] s1, String[] s2) {
        int answer = 0;
        
        Set<String> a = new HashSet<>();
        
        for(int i=0; i<s1.length; i++){
            a.add(s1[i]);
        }
        for(int i=0; i<s2.length; i++){
            if(a.contains(s2[i])){
                answer ++;
            }
        }    
    
        
        return answer;
    }
}
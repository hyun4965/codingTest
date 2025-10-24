import java.util.*;

class Solution {
    public String solution(String[] cards1, String[] cards2, String[] goal) {
        Queue<String> que1 = new LinkedList<>(); 
        Queue<String> que2 = new LinkedList<>();
        for(int i=0; i<cards1.length; i++){
            que1.add(cards1[i]);
        }
        for(int i=0; i<cards2.length;i++){
            que2.add(cards2[i]);
        }
        
        
        for(String word : goal){
            
            if(!que1.isEmpty() && que1.peek().equals(word)){
                que1.poll(); 
            } else if(!que2.isEmpty() && que2.peek().equals(word)){
                que2.poll();
            } else {
                return "No";
            }
        }
        return "Yes";
    }
}
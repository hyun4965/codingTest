class Solution {
    public int[] solution(String[] park, String[] routes) {
        int h = park.length; 
        int w = park[0].length(); 
        
        int curR = 0; 
        int curC = 0; 
        
        for(int i=0; i<h; i++){
            for(int j=0; j<w; j++){
                if(park[i].charAt(j) == 'S'){
                    curR = i;
                    curC = j;
                    break;
                }
            }
        }
        
        for(String route : routes){
            String[] split = route.split(" ");
            String op = split[0]; 
            int n = Integer.parseInt(split[1]); 
            
            int tempR = curR;
            int tempC = curC;
            boolean canMove = true;
            
            for(int i=0; i<n; i++){
                if(op.equals("N")) tempR--;
                else if(op.equals("S")) tempR++;
                else if(op.equals("W")) tempC--;
                else if(op.equals("E")) tempC++;
                
                if(tempR < 0 || tempR >= h || tempC < 0 || tempC >= w){
                    canMove = false;
                    break;
                }
                
                if(park[tempR].charAt(tempC) == 'X'){
                    canMove = false;
                    break;
                }
            }
            
            if(canMove){
                curR = tempR;
                curC = tempC;
            }
        }
        
        return new int[]{curR, curC};
    }
}
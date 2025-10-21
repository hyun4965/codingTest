class Solution {
    public int solution(int[][] sizes) {
        int longMax = 1;
        int shortMax = 1;
        
        for(int i = 0; i < sizes.length; i++){
            int longer = Math.max(sizes[i][0], sizes[i][1]);
            int shorter = Math.min(sizes[i][0], sizes[i][1]);
            
            if(longer > longMax) {
                longMax = longer;
            }
            if(shorter > shortMax) {
                shortMax = shorter;
            }
        }
        
        return longMax * shortMax;
    }
}
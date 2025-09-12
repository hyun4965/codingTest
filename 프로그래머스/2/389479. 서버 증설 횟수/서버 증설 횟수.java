class Solution {
    public int solution(int[] players, int m, int k) {
        int answer = 0;
        int[] runningServers = new int[24];
        
        for(int i = 0; i < 24; i++){

            int requiredServers = players[i] / m;
    
            if(requiredServers > runningServers[i]){
                int addServer = requiredServers - runningServers[i];
                
                answer += addServer;

                for(int j = 0; j < k; j++){
                    if(i + j < 24){
                        runningServers[i + j] += addServer;
                    }
                }
            }
        }
        
        return answer;
    }
}
import java.util.*;

class Solution {
    public String[] solution(String[] players, String[] callings) {
        Map<String, Integer> playerRanks = new HashMap<>();
        for (int i = 0; i < players.length; i++) {
            playerRanks.put(players[i], i);
        }

        for (String calledPlayer : callings) {
            int currentRank = playerRanks.get(calledPlayer);
            
            String playerInFront = players[currentRank - 1];
            
            players[currentRank - 1] = calledPlayer;
            players[currentRank] = playerInFront;
            
            playerRanks.put(calledPlayer, currentRank - 1);
            playerRanks.put(playerInFront, currentRank);
        }
        
        return players;
    }
}
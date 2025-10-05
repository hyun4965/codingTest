import java.util.*;

class Solution {
    public int solution(int[] picks, String[] minerals) {
        int answer = 0;
        int totalPicks = picks[0] + picks[1] + picks[2];

        List<int[]> chunks = new ArrayList<>();
        
        for (int i = 0; i < minerals.length && i < totalPicks * 5; i += 5) {
            int dia = 0, iron = 0, stone = 0;
            for (int j = i; j < i + 5 && j < minerals.length; j++) {
                switch (minerals[j]) {
                    case "diamond": dia++; break;
                    case "iron": iron++; break;
                    case "stone": stone++; break;
                }
            }
            chunks.add(new int[]{dia, iron, stone});
        }

        chunks.sort((a, b) -> {
            if (b[0] != a[0]) return b[0] - a[0]; 
            if (b[1] != a[1]) return b[1] - a[1]; 
            return b[2] - a[2];         
        });

        for (int[] chunk : chunks) {
            int diaCount = chunk[0];
            int ironCount = chunk[1];
            int stoneCount = chunk[2];
            
            if (picks[0] > 0) { 
                answer += diaCount * 1 + ironCount * 1 + stoneCount * 1;
                picks[0]--;
            } else if (picks[1] > 0) { 
                answer += diaCount * 5 + ironCount * 1 + stoneCount * 1;
                picks[1]--;
            } else if (picks[2] > 0) { 
                answer += diaCount * 25 + ironCount * 5 + stoneCount * 1;
                picks[2]--;
            }
        }

        return answer;
    }
}
import java.util.*;
class Solution {
    public int[] solution(String[] genres, int[] plays) {
        
        Map<String, Integer> total = new HashMap<>();
        Map<String, List<int[]>> songs = new HashMap<>();
        
        for (int i = 0; i < genres.length; i++) {
            String g = genres[i];
            int p = plays[i];
            
            total.put(g, total.getOrDefault(g, 0) + p);
            
            songs.computeIfAbsent(g, k -> new ArrayList<>())
                 .add(new int[] { i, p });
        }
        
        List<String> orderedGenres = new ArrayList<>(total.keySet());
        orderedGenres.sort((a, b) -> total.get(b) - total.get(a));
        
        List<Integer> result = new ArrayList<>();
        for (String g : orderedGenres) {
            List<int[]> list = songs.get(g);
            list.sort((x, y) -> {
                if (y[1] != x[1]) return y[1] - x[1]; 
                return x[0] - y[0];
            });
            
            result.add(list.get(0)[0]);
            if (list.size() >= 2) {
                result.add(list.get(1)[0]);
            }
        }
        
        int[] answer = new int[result.size()];
        for (int i = 0; i < result.size(); i++) {
            answer[i] = result.get(i);
        }
        return answer;
    }
}
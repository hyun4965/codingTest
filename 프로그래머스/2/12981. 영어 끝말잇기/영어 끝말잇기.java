import java.util.*;
class Solution {
    public int[] solution(int n, String[] words) {
        int[] answer = new int[2];
        Set<String> usedWords = new HashSet<>();

        usedWords.add(words[0]);
        
        for (int i = 1; i < words.length; i++) {
            String currentWord = words[i];
            String prevWord = words[i - 1];
            
            char lastChar = prevWord.charAt(prevWord.length() - 1);
            char firstChar = currentWord.charAt(0);
            
            if (lastChar != firstChar || usedWords.contains(currentWord)) {

                int personNumber = (i % n) + 1;

                int turnNumber = (i / n) + 1;
                
                answer[0] = personNumber;
                answer[1] = turnNumber;
                return answer;
            }
            
            usedWords.add(currentWord);
        }

        return answer;
    }
}
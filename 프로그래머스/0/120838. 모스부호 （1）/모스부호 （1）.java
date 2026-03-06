class Solution {
    public String solution(String letter) {
        
        String[] morse = {
            ".-","-...","-.-.","-..",".","..-.","--.","....","..",".---",
            "-.-",".-..","--","-.","---",".--.","--.-",".-.","...","-",
            "..-","...-",".--","-..-","-.--","--.."
        };
        
        String[] words = letter.split(" ");
        String answer = "";
        
        for (String w : words) {
            for (int i = 0; i < morse.length; i++) {
                if (w.equals(morse[i])) {
                    answer += (char)('a' + i);
                    break;
                }
            }
        }
        
        return answer;
    }
}
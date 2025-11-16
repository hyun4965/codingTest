class Solution {
    public String solution(String[] survey, int[] choices) {
        int[] score = new int[26];

        for (int i = 0; i < survey.length; i++) {
            String s = survey[i];
            char disagree = s.charAt(0); 
            char agree = s.charAt(1);  
            int choice = choices[i];

            int diff = choice - 4; 

            if (diff < 0) { 
                score[disagree - 'A'] += -diff; 
            } else if (diff > 0) { 
                score[agree - 'A'] += diff;    
            }

        }

        StringBuilder sb = new StringBuilder();

        sb.append(pickType(score, 'R', 'T'));
        sb.append(pickType(score, 'C', 'F'));
        sb.append(pickType(score, 'J', 'M'));
        sb.append(pickType(score, 'A', 'N'));

        return sb.toString();
    }

    private char pickType(int[] score, char a, char b) {
        int sa = score[a - 'A'];
        int sb = score[b - 'A'];

        if (sa > sb) return a;
        else if (sa < sb) return b;
        else return a < b ? a : b; 
    }
}

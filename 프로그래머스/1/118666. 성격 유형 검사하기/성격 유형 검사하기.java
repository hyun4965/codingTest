import java.util.*;

class Solution {
    public String solution(String[] survey, int[] choices) {
        int[] score = new int[26];

        for (int i = 0; i < survey.length; i++) {
            char disagreeType = survey[i].charAt(0);
            char agreeType    = survey[i].charAt(1); 
            int choice = choices[i];

            if (choice < 4) {
                score[disagreeType - 'A'] += 4 - choice;
            } else if (choice > 4) {
                score[agreeType - 'A'] += choice - 4;
            }
        }

        StringBuilder result = new StringBuilder(4);
        result.append(score['R' - 'A'] >= score['T' - 'A'] ? 'R' : 'T');
        result.append(score['C' - 'A'] >= score['F' - 'A'] ? 'C' : 'F');
        result.append(score['J' - 'A'] >= score['M' - 'A'] ? 'J' : 'M');
        result.append(score['A' - 'A'] >= score['N' - 'A'] ? 'A' : 'N');

        return result.toString();
    }
}

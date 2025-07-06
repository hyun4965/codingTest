class Solution {
    boolean solution(String s) {
        // 소문자로 변환
        String py = s.toLowerCase();
        int pCount = 0;
        int yCount = 0;

        for (int i = 0; i < py.length(); i++) {
            char ch = py.charAt(i);
            if (ch == 'p') {
                pCount++;
            } else if (ch == 'y') {
                yCount++;
            }
        }

        return pCount == yCount;
    }
}

class Solution {
    public String[] solution(String[] picture, int k) {
        String[] answer = new String[picture.length * k];

        int index = 0;

        for (String line : picture) {
            StringBuilder sb = new StringBuilder();

            for (int i = 0; i < line.length(); i++) {
                char ch = line.charAt(i);

                for (int j = 0; j < k; j++) {
                    sb.append(ch);
                }
            }

            String expandedLine = sb.toString();

            for (int i = 0; i < k; i++) {
                answer[index++] = expandedLine;
            }
        }

        return answer;
    }
}
class Solution {
    public int solution(int[] ingredient) {
        int answer = 0;
        StringBuilder sb = new StringBuilder();

        for (int num : ingredient) {
            sb.append(num);

            if (sb.length() >= 4) {
                int len = sb.length();
                if (sb.substring(len - 4, len).equals("1231")) {
                    sb.delete(len - 4, len); 
                    answer++;
                }
            }
        }

        return answer;
    }
}

class Solution {
    public int solution(String my_string) {
        int answer = 0;
        
        String[] numbers = my_string.replaceAll("[a-zA-Z]", " ").split(" ");
        
        for (String num : numbers) {
            if (!num.isEmpty()) {
                answer += Integer.parseInt(num);
            }
        }
        
        return answer;
    }
}
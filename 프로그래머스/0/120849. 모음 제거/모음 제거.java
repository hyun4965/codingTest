class Solution {
    public String solution(String my_string) {
        StringBuilder sb = new StringBuilder();
        String vowels = "aeiou"; 

        for (char ch : my_string.toCharArray()) {
            if (vowels.indexOf(ch) == -1) { 
                sb.append(ch);
            }
        }

        return sb.toString();
    }
}

class Solution {
    public String solution(String my_string) {
        StringBuilder sb = new StringBuilder();

        for (char c : my_string.toCharArray()) {
            sb.append(Character.isLowerCase(c) ? Character.toUpperCase(c) : Character.toLowerCase(c));
        }
        return sb.toString();
    }
}

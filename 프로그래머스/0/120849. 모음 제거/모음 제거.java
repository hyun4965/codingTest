class Solution {
    public String solution(String my_string) {
        StringBuilder sb = new StringBuilder(my_string.length());

        for (int i = 0; i < my_string.length(); i++) {
            char c = my_string.charAt(i);
            switch (c) {
                case 'a':
                case 'e':
                case 'i':
                case 'o':
                case 'u':
                    break;
                default:
                    sb.append(c);
            }
        }
        return sb.toString();
    }
}

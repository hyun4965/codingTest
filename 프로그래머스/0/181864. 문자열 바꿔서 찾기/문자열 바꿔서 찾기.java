class Solution {
    public int solution(String myString, String pat) {
        StringBuilder sb = new StringBuilder(myString.length());
        
        for (int i = 0; i < myString.length(); i++) {
            char c = myString.charAt(i);
            sb.append(c == 'A' ? 'B' : 'A');
        }
        
        return sb.toString().contains(pat) ? 1 : 0;
    }
}

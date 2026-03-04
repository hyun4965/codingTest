class Solution {
    public String solution(String myString, String pat) {
        int last = -1;
        for (int i = 0; i <= myString.length() - pat.length(); i++) {
            if (myString.startsWith(pat, i)) last = i;
        }
        return myString.substring(0, last + pat.length());
    }
}